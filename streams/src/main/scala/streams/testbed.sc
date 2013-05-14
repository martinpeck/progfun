package streams

object testbed {

    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin                  //> level  : String = ooo-------
                                                  //| oSoooo----
                                                  //| ooooooooo-
                                                  //| -ooooooooo
                                                  //| -----ooToo
                                                  //| ------ooo-

    var x = Vector(Vector("c", "d"), Vector("e", "f"))
                                                  //> x  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Str
                                                  //| ing]] = Vector(Vector(c, d), Vector(e, f))
    
    val y = x.flatten                             //> y  : scala.collection.immutable.Vector[String] = Vector(c, d, e, f)
    
    y.indexWhere(x=> x == "e")                    //> res0: Int = 2

}