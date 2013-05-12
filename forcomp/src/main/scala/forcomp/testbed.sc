package forcomp
import Anagrams._
object testbed {
  val s = "heLlo"                                 //> s  : String = heLlo
  s.groupBy(_.toLower).map(x => (x._1, x._2.length)).toList.sortBy(x => x._1)
                                                  //> res0: List[(Char, Int)] = List((e,1), (h,1), (l,2), (o,1))
 
  val sen = List("hello", "there")                //> sen  : List[String] = List(hello, there)
  sen flatten                                     //> res1: List[Char] = List(h, e, l, l, o, t, h, e, r, e)
  
  // Anagrams.wordAnagrams("married")
  // Anagrams.wordAnagrams("tea")
    
  def combinations2 (occurrences: Occurrences): List[Occurrences] = {
    occurrences match
    {
      case List() => List(Nil)
	    case head :: tail => {
	      (for {
	        rest <- combinations2(tail)
	        x <- (for (i <- 1 to head._2) yield (head._1, i))
	      } yield x :: rest) ++ combinations2(tail)
	    }
		}
  }                                               //> combinations2: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagr
                                                  //| ams.Occurrences]
  
  combinations2(List(('a', 1), ('b', 2)))         //> res2: List[forcomp.Anagrams.Occurrences] = List(List((a,1), (b,1)), List((a,
                                                  //| 1), (b,2)), List((a,1)), List((b,1)), List((b,2)), List())
  
  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    ((y foldLeft x)((acc, item) => acc map (i => if (i._1 == item._1) (i._1, i._2 - item._2) else i))).filter(foo => foo._2 > 0)
  }                                               //> subtract: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)
                                                  //| forcomp.Anagrams.Occurrences
	val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> lard  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
	val r = List(('r', 1))                    //> r  : List[(Char, Int)] = List((r,1))
	val lad = List(('a', 1), ('d', 1), ('l', 1))
                                                  //> lad  : List[(Char, Int)] = List((a,1), (d,1), (l,1))
  
  subtract(lard, r)                               //> res3: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1))
  
  
    def sentenceAnagrams(sentence: Sentence): List[Sentence] = {
    
    def inner(occ: Occurrences): List[Sentence] = {
      if (occ.isEmpty)
        List(Nil)
      else {
        val combs = combinations(occ)

        for {
          comb <- combs
          words = dictionaryByOccurrences.getOrElse(comb, Nil)
          w <- words
          rest <- inner(subtract(occ, comb))
        }
        yield w :: rest
      }
    }
    
    inner(sentenceOccurrences(sentence))
    
  }                                               //> sentenceAnagrams: (sentence: forcomp.Anagrams.Sentence)List[forcomp.Anagram
                                                  //| s.Sentence]
  val sentence = List("Matthew", "t")             //> sentence  : List[String] = List(Matthew, t)
  //sentenceAnagrams(sentence)
  sentenceOccurrences(sentence)                   //> res4: forcomp.Anagrams.Occurrences = List((a,1), (e,1), (h,1), (m,1), (t,2)
                                                  //| , (w,1), (t,1))
  wordOccurrences("Matthew")                      //> res5: forcomp.Anagrams.Occurrences = List((a,1), (e,1), (h,1), (m,1), (t,2)
                                                  //| , (w,1))
  (sentence foldLeft "")(_ + _)                   //> res6: String = Matthewt
 }