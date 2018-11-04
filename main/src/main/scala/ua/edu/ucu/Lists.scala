package ua.edu.ucu

object Lists {
  import scala.collection.immutable._
  val l1 = 1 :: 2 :: 3 :: Nil
  // Corresponds to
  val l2 = ::(1, ::(2, ::(3, Nil))) // :: - case class also named Cons
  // But in fact this works like
  Nil.::(3).::(2).::(1)

  /*sealed trait List[+T]
  case object Nil extends List[Nothing]
  case class ::[+T](head: T, tail: List[T]) extends List[T]
*/

}
