package ua.edu.ucu.graded

object ListDef {

  sealed trait List[A]
  case object Nil extends List[Nothing]
  case class Cons[A](head: A, tail: List[A]) extends List[A]

  // TODO
  // Make the above List definition covariant by type A
  //val test: List[Any] = Cons(1, Nil)
  //val test: List[Long] = Cons(1, Nil)

  // TODO - Implement foldRight function
  def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = ???

  // TODO - implement in terms of foldRight
  def sum(l: List[Int]): Int = ???

  // TODO - implement in terms of foldRight
  def product(l: List[Int]): Int = ???
}
