package week3

object rationals {
  val x = new Rational(1,3)                       //> x  : week3.Rational = 1/3
  x.numer                                         //> res0: Int = 1
 	x.denom                                   //> res1: Int = 3
 	
 	val y = new Rational(5,7)                 //> y  : week3.Rational = 5/7
 	
 	x.add(y)                                  //> res2: week3.Rational = 22/21
 	
 	val z = new Rational(3,2)                 //> z  : week3.Rational = 3/2
 	
 	x.neg                                     //> res3: week3.Rational = 1/-3
 	
 	x.sub(y).sub(z)                           //> res4: week3.Rational = -79/42
 	
 	y.add(y)                                  //> res5: week3.Rational = 10/7
 	
 	x.less(y)                                 //> res6: Boolean = true
 	
 	x < y                                     //> res7: Boolean = true
 	y < x                                     //> res8: Boolean = false
 	
 	x.max(y)                                  //> res9: week3.Rational = 5/7
 	y.max(x)                                  //> res10: week3.Rational = 5/7
 	
 	x max y                                   //> res11: week3.Rational = 5/7
 	y max x                                   //> res12: week3.Rational = 5/7
 	
 	x add y                                   //> res13: week3.Rational = 22/21
 	y add z                                   //> res14: week3.Rational = 31/14
 	// val strange = new Rational(1,0)
 	// strange.add(strange)
 	
 	new Rational(2)                           //> res15: week3.Rational = 2/1
}

class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must be non-zero")
	
	def this(x: Int) = this(x, 1)
	
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	
	
	def numer = x
	def denom = y
	
	def less(that: Rational) = this.numer * that.denom < that.numer * this.denom
	def < (that: Rational) = less(that)

	def max(that: Rational) = if(this.less(that)) that else this
	
	def add(that: Rational) =
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom)
		
	def neg = new Rational(-numer, denom)
	
	def sub(that: Rational) = add(that.neg)
					
	override def toString = {
			val g = gcd(x,y)
			numer / g + "/" + denom / g
		}
}