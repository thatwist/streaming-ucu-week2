package ua.edu.ucu.bonus

import scala.language.higherKinds

object MonadSimple {

  trait Monad[A] {
    def map[B](f: A => B): Monad[B]
    def flatMap[B](f: A => Monad[B]): Monad[B]
    def withFilter(p: A => Boolean): Monad[A]
    def foreach(b: A => Unit): Unit
  }

  // Lets say I want define List on my own
  sealed trait MyList[+T] // extends Monad[T] - doesn't work
  case object Nil extends MyList[Nothing]
  case class ::[+T](head: T, tail: MyList[T]) extends MyList[T]

  // doesn't work as well
  // val myListMonad = new Monad[] {}
}