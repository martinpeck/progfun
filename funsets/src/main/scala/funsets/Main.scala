package funsets

object Main extends App {
	import FunSets._
  
	val s1 = singletonSet(1)
	val s2 = singletonSet(2)
	val s3 = singletonSet(3)
	val u1 = union(s1, s2)
	val u2 = union(s2, s3)
	val u3 = union(u1, u2)
	
	val test1 = forall(u3, (x: Int) => x < 5)
	val test2 = forall(u3, (x: Int) => x > 0)
	val test3 = forall(u3, (x: Int) => x % 2 == 0)
	
	println(contains(singletonSet(1), 1))
	printSet(u3)
	println(test1)
	println(test2)
	println(test3)
}
