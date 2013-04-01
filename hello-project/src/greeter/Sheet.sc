package greeter

object Sheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	val x = 3                                 //> x  : Int = 3
  def increase(i: Int) = i + 2                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 5
}