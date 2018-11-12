// Let's say I want to define some very generic functionality of adding
// two 'things' - arbitrary things.
// I want this functionality be defined for any possible type A
def plus[A](a1: A, a2: A): A = ???    	// plus: [A](a1: A, a2: A)A

// One way would be to define everything extending this trait:
trait Plus1[A] {
  def plus(a2: A): A
}
def plus1[A <: Plus1[A]](a1: A, a2: A): A = a1.plus(a2)
// plus: [A <: Plus[A]](a1: A, a2: A)A
case class IntPlus1(a1: Int) extends Plus1[Int] {
  override def plus(a2: Int) = a1 + a2
}
plus1[IntPlus1](IntPlus1(1), IntPlus1(2))

// Not very convenient when I want to define such functionality for existing things
// like Strings, Lists, or any 3rd party code. Code becomes very coupled in any case.
// ==========================
// There is another way -
// In Scala, a combination of:
//  - parameterized trait exposing some functionality (like Plus2)
//  - parameterized method which takes implicit argument of type of that trait
//  - a set of implicit instances of that trait for a given concrete types
// is called TYPE-CLASS PATTERN
trait Plus2[A] {
  def plus(a1: A, a2: A): A
} // defined trait Plus2


def plus2[A: Plus2](a1: A, a2: A): A = implicitly[Plus2[A]].plus(a1, a2)

// [A: Plus2] above is called 'Context Bound' and is translated exactly into following:

def plus2[A](a1: A, a2: A)(implicit ev1: Plus2[A]): A = ev1.plus(a1, a2)
// plus: [A](a1: A, a2: A)(implicit evidence$1: PlusBi[A])A

// Spend some time to 'get' the idea here.
// You can read 1st method definition like 'function plus2 works for all types A for which exist instance of Plus2[A] in the scope'
// Refer to class Ordering[T] and List.sort method from the standard method for better understanding
// Think about Comparator pattern from OOP

// This may seem a little bit verbose initially,
// in other languages this pattern can be defined using other syntactic constructions.
// For instance in Haskell this is a first-class language construction (like function or regular OOP class)

// Look into 'cats' library first pages of documentation as additional resource