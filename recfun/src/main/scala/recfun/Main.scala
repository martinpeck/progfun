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
    
    assert(balance("(if (zero? x) max (/ 1 x))".toList), "test 1")
    assert(balance("I told him (that it's not (yet) done). (But he wasn't listening)".toList), "test 2")
    assert(!balance(":-)".toList), "test 3")
    assert(!balance("())(".toList), "test 4")

  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 
    else pascal(c, r - 1) + pascal(c - 1, r - 1) 
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(chars: List[Char], depth: Int) : Boolean = 
    {
      if (chars.isEmpty)
      {
      	depth == 0
      }
      else if (depth < 0)
      {
        false
      }
      else
      {
        if (chars.head == '(')
          loop(chars.tail, depth + 1)
        else if (chars.head == ')')
          loop(chars.tail, depth - 1)
        else
          loop(chars.tail, depth)
      }
    }
    loop(chars, 0)
  }

  /**
   * Exercise 3
   * 
   * how much money do we have?
   * 	0: add one to accumulator
   *  	> head: move on to next coin
   *    else: continue on with this coin, subtracting head 
   */
  def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1 else if (money < 0 || coins.isEmpty) 0
      else
        countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
