package ua.edu.ucu

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.PropertyChecks

class SimpleSpec extends FlatSpec with PropertyChecks with Matchers {

  "test" should "pass" in {
    assert(0 == 0)
  }

  "An empty Set" should "have size 0" in {
    assert(Set.empty.size == 0)
    Set.empty.size shouldEqual 0
  }


  it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

  def plus(a: Int, b: Int): Int = a + b

  "plus" should "work" in {
    assert(plus(1, 2) == 3)
  }

  class Rational(n: Int, d: Int) {
    require(d != 0)
    val numer: Int = if (d < 0) -1 * n else n
    val denom: Int = d.abs
    override def toString: String = numer + " / " + denom
  }
  // test
  forAll { (n: Int, d: Int) =>
    whenever (d != 0 && d != Integer.MIN_VALUE
      && n != Integer.MIN_VALUE) {
      val f = new Rational(n, d)
      if (n < 0 && d < 0 || n > 0 && d > 0)
        f.numer should be > 0
      else if (n != 0)
        f.numer should be < 0
      else
        f.numer shouldEqual 0
      f.denom should be > 0
    }
  }

}
