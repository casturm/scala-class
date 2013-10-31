package forcomp

import Anagrams._

object anagram {
  var sentence = List("Yes", "man")               //> sentence  : List[String] = List(Yes, man)
  //var sentence = List("To", "be")
  var o = sentenceOccurrences(sentence)           //> o  : forcomp.Anagrams.Occurrences = List((a,1), (e,1), (m,1), (n,1), (s,1), 
                                                  //| (y,1))
  var c = combinations(o)                         //> c  : List[forcomp.Anagrams.Occurrences] = List(List(), List((a,1)), List((e,
                                                  //| 1)), List((m,1)), List((n,1)), List((s,1)), List((y,1)), List((a,1), (e,1)),
                                                  //|  List((a,1), (m,1)), List((a,1), (n,1)), List((a,1), (s,1)), List((a,1), (y,
                                                  //| 1)), List((e,1), (m,1)), List((e,1), (n,1)), List((e,1), (s,1)), List((e,1),
                                                  //|  (y,1)), List((m,1), (n,1)), List((m,1), (s,1)), List((m,1), (y,1)), List((n
                                                  //| ,1), (s,1)), List((n,1), (y,1)), List((s,1), (y,1)), List((a,1), (e,1), (m,1
                                                  //| )), List((a,1), (e,1), (n,1)), List((a,1), (e,1), (s,1)), List((a,1), (e,1),
                                                  //|  (y,1)), List((a,1), (m,1), (n,1)), List((a,1), (m,1), (s,1)), List((a,1), (
                                                  //| m,1), (y,1)), List((a,1), (n,1), (s,1)), List((a,1), (n,1), (y,1)), List((a,
                                                  //| 1), (s,1), (y,1)), List((e,1), (m,1), (n,1)), List((e,1), (m,1), (s,1)), Lis
                                                  //| t((e,1), (m,1), (y,1)), List((e,1), (n,1), (s,1)), List((e,1), (n,1), (y,1))
                                                  //| , List((e,1), (s,1), (y,1)), List((m,1), (n,1), (s,1)), List((m,1), (n,1), (
                                                  //| y,1)), List((m,1), (s,1)
                                                  //| Output exceeds cutoff limit.
  
  //subtract(c, List(('a',1),('e',1),('n',1)))
  
//  for (c <- combinations(o))
//    println(dictionaryByOccurrences get (c))
//    println(anagramsHelp(c))
  //(for (o1 <- combinations(occurrences)) yield ).flatten
  
  def anagramsHelp(occurrences: Occurrences): List[Sentence] = {
    print("o "); println(occurrences)
    if (occurrences.isEmpty) List(List())
    else {
      (
      for {
        c <- combinations(occurrences)
        word <- dictionaryByOccurrences(c)
      //} yield { print("ws "); println(words)
      //  for {
        rest <- anagramsHelp(subtract(occurrences, c))
        } yield {
            print("w "); println(word);
            print("r "); println(rest);
            word :: rest
            //List()
          }
      //}
      ).toList
	  }
	}                                         //> anagramsHelp: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagra
                                                  //| ms.Sentence]
	
	var anagrams = anagramsHelp(sentenceOccurrences(sentence))
                                                  //> o List((a,1), (e,1), (m,1), (n,1), (s,1), (y,1))
                                                  //| o List((e,1), (n,1), (s,1), (y,1))
                                                  //| o List((s,1), (y,1))
                                                  //| o List((n,1))
                                                  //| o List((e,1), (m,1), (s,1), (y,1))
                                                  //| o List((s,1), (y,1))
                                                  //| o List((s,1), (y,1))
                                                  //| o List((e,1), (s,1))
                                                  //| o List((m,1))
                                                  //| o List((e,1), (m,1), (n,1), (y,1))
                                                  //| o List((n,1), (y,1))
                                                  //| o List((n,1), (y,1))
                                                  //| o List((m,1), (y,1))
                                                  //| o List()
                                                  //| w my
                                                  //| r List()
                                                  //| w en
                                                  //| r List(my)
                                                  //| o List((e,1), (n,1))
                                                  //| o List()
                                                  //| w en
                                                  //| r List()
                                                  //| w my
                                                  //| r List(en)
                                                  //| o List((y,1))
                                                  //| w as
                                                  //| r List(en, my)
                                                  //| w as
                                                  //| r List(my, en)
                                                  //| o List((a,1), (n,1), (s,1), (y,1))
                                                  //| o List((s,1), (y,1))
                                                  //| o List((n,1), (y,1))
                                                  //| o List((y,1))
                                                  //| o List((s,1))
                                                  //| o List((s,1))
                                                  //| o List((n,1))
                                                  //| o List((a,1), (n,1), (s,1), (y,1))
                                                  //| o List((s,1), (y,1))
                                                  //| o List((n,1), (y,1))
                                                  //| o List((y,1))
                                                  //| o List((s,1))
                                                  //| o List((s,1))
                                                  //| o List((n,1))
                                                  //| o List((a,1), (m,1), (s,1), (y,1
                                                  //| Output exceeds cutoff limit.
  anagrams                                        //> res0: List[forcomp.Anagrams.Sentence] = List(List(as, en, my), List(as, my,
                                                  //|  en), List(en, as, my), List(en, my, as), List(my, as, en), List(my, en, as
                                                  //| ), List(my, sane), List(my, Sean), List(man, yes), List(say, men), List(men
                                                  //| , say), List(yes, man), List(sane, my), List(Sean, my))
//  build(sentenceOccurrences(sentence))
}