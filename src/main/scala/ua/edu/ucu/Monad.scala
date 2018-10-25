package ua.edu.ucu

import scala.language.higherKinds

// lets say I don't like List from std lib for any reason
sealed trait MyList[+T]
case object MyNil extends MyList[Nothing]
case class Cons[+T](head: T, tail: MyList[T]) extends MyList[T]

trait Monad[F[_]] {
  def unit[A](a: A): F[A]
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  def map[A, B](fa: F[A])(f: A => B): F[B]
  def filter[A](fa: F[A])(p: A => Boolean): F[A]
}

object Monad {
  implicit val myListMonad: Monad[MyList] = new Monad[MyList] {
    override def unit[A](a: A): MyList[A] = ??? // todo
    override def flatMap[A, B](fa: MyList[A])(f: A => MyList[B]): MyList[B] = ??? // todo
    override def map[A, B](fa: MyList[A])(f: A => B): MyList[B] = ??? // todo
    override def filter[A](fa: MyList[A])(p: A => Boolean): MyList[A] = ??? // todo
  }
}

object MonadLaws {
  /* ... */
}

object ListOps {
  implicit def myListToListOps[A](l: MyList[A])(implicit monad: Monad[MyList]): ListOps[A] =
    new ListOps[A](l)(monad)
  class ListOps[A](l: MyList[A])(implicit val monad: Monad[MyList]) {
    def ::(a: A): MyList[A] = Cons[A](a, l)
    def unit(a: A): MyList[A] = monad.unit(a)
    def map[B](f: A => B): MyList[B] = monad.map(l)(f)
    /* ... */
  }
}

object Usage {
  import ListOps._
  import Monad._

  new ListOps(MyNil).::(1)
  val list: MyList[Int] = 1 :: 2 :: 3 :: MyNil

  list.map(_ + 1)
}