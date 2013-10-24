package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t2) === 9)
    }
  }
  
  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }
  
  test("count of a chars in a list") {
    assert(2 === count('a', List('a', 'b', 'a')))
  }
  
  test("times of a chars in a list") {
    assert(List(('a', 2), ('b', 1)) === times(List('a', 'b', 'a')))
  }
   
  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("test singleton of Nil") {
    assert(false === singleton(Nil))
  }
  
  test("test singleton of two CodeTree") {
    assert(false === singleton(List(Leaf('a',1), Leaf('b',1))))
  }

  test("test singleton of single CodeTree") {
    assert(true === singleton(List(Fork(Leaf('a',1), Leaf('b',1), List('a','b'), 2))))
  }
  
  test("test singleton of single Leaf") {
    assert(true === singleton(List(Leaf('a',1))))
  }

  test("until on list of CodeTrees") {
    new TestTrees {
      assert(List(t2) === until(singleton, combine)(List(Leaf('a',2), Leaf('b',3), Leaf('d',4))))
    }
  } 
  
  test("createCodeTree Nil") {
    new TestTrees {
      intercept[IllegalArgumentException] {
        createCodeTree(Nil)
      }
    }
  }
  
  test("createCodeTree List()") {
    new TestTrees {
      intercept[IllegalArgumentException] {
        createCodeTree(List())
      }
    }
  }
  
  test("createCodeTree t1") {
    new TestTrees {
      assert(t1 === createCodeTree(List('a','a','b','b','b')))
    }
  }
  
  test("encode Nil") {
    new TestTrees {
      assert(Nil === encode(t1)(Nil))
    }
  }
  
  test("encode empty List") {
    new TestTrees {
      assert(Nil === encode(t1)(List()))
    }
  }
  
  test("encode ab using t1") {
    new TestTrees {
      assert(List(0,1) === encode(t1)("ab".toList))
    }
  }
  
  test("encode ab using with Leaf only") {
    assert(List() === encode(Leaf('a',1))("ab".toList))
  }
  
  test("encodeChar ab using with Leaf only") {
    assert(List() === encodeChar(Leaf('a',1), Leaf('a',1), 'b', "bc".toList))
  }
    
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("convert t1") {
    new TestTrees {
      assert(List(('a', List(0)), ('b', List(1))) === convert(t1))
    }
  }
  
  test("convert t2") {
    new TestTrees {
      assert(List(('a', List(0,0)), ('b', List(0,1)), ('d', List(1))) === convert(t2))
    }
  }
}
