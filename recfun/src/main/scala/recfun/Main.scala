package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r > 0 && c < r) {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
    else {
      if (c == 0 || c == r) 1
      else 0
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance(paren: => Int, chars: List[Char]): Int = {
      if (chars.isEmpty) return paren
      if (paren < 0) return paren
      
	  if (chars.head == '(') balance(paren + 1, chars.tail)
	  else if (chars.head == ')') balance(paren - 1, chars.tail);
	  else balance(paren, chars.tail)
    }
    
    if (!chars.isEmpty) balance(0, chars) == 0
    else true
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) return 1
    else if (money < 0 || coins.isEmpty) return 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
