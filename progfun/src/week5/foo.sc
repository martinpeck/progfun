package week5

object foo {
  val s = "heLlo"                                 //> s  : String = heLlo
  s.groupBy(_.toLower).map(x => (x._1, x._2.length)).toList.sortBy(x => x._1)
                                                  //> res0: List[(Char, Int)] = List((e,1), (h,1), (l,2), (o,1))
 
  val sen = List("hello", "there")                //> sen  : List[String] = List(hello, there)
  sen flatten                                     //> res1: List[Char] = List(h, e, l, l, o, t, h, e, r, e)
}