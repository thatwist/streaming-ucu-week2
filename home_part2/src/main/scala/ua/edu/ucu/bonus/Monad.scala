package ua.edu.ucu.bonus

import scala.language.{higherKinds, reflectiveCalls}
import scala.util.Try

// lets say I don't like List from std lib for any reason
sealed trait MyList[+T]
case object MyNil extends MyList[Nothing]
case class Cons[+T](head: T, tail: MyList[T]) extends MyList[T]

// The right way - define a type class with higher-kinded type
trait Monad[F[_]] {
  def unit[A](a: A): F[A]
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  def map[A, B](fa: F[A])(f: A => B): F[B]
  def filter[A](fa: F[A])(p: A => Boolean): F[A]
}

// type class instances live in companion object usually
object MonadInstances {

  implicit val myListMonad: Monad[MyList] = ??? // TODO
  implicit val optionMonad: Monad[Option] = ??? // TODO
  implicit val tryMonad: Monad[Try] = ??? // TODO

  import RightProjectionAux._
  implicit def rightProjMonad[A]: Monad[RightProjectionB[A]#Aux] = ??? // TODO
  // the above mess with the types could be written using a hacky one-liner
  // which is called in scala 'type-lambda'
  implicit def leftProjMonad[B]: Monad[({type l[A] = Either.LeftProjection[A, B]})#l] = ???
}

// Aux type to make single-type-parametered type-constructor
object RightProjectionAux {
  type RightProjectionB[A] = {
    type Aux[B] = scala.Either.RightProjection[A, B]
  }
}

// monad laws - define functions which can test laws for some Monad instance
// write unit tests using ScalaCheck which check laws for a particular monad instance from above
object MonadLaws {
  /* TODO - refer to main project MonadLaws.sc*/
}

// implicits from companion object should not be imported explicitly
// compiler will look into here while resolving implicit instances
object MyList {
  implicit def myListToListOps[A](l: MyList[A])(implicit monad: Monad[MyList]): ListOps[A] =
    new ListOps[A](l)(monad)
  class ListOps[A](l: MyList[A])(implicit val monad: Monad[MyList]) {
    def ::(a: A): MyList[A] = Cons[A](a, l)
    def unit(a: A): MyList[A] = monad.unit(a)
    def map[B](f: A => B): MyList[B] = monad.map(l)(f)
    /* TODO - finish ListOps*/
  }
}

// TODO make this work
object Usage extends App {
  //import MonadInstances._

  //val list: MyList[Int] = 1 :: 2 :: 3 :: MyNil

  //list.map(_ + 1)
}