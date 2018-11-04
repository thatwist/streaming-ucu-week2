case class Person(name: String,
                  isMale: Boolean,
                  children: Person*)
val lara = Person("Lara", false)
val bob = Person("Bob", true)
val julie = Person("Julie", false, lara, bob)
val persons = List(lara, bob, julie)

persons filter (p => !p.isMale) flatMap (p =>
  (p.children map (c => (p.name, c.name))))

// equivalent to

for (p <- persons; if !p.isMale; c <- p.children)
  yield (p.name, c.name)

// or

for {
  p <- persons
  if !p.isMale
  c <- p.children
} yield (p.name, c.name)

// refy helps:

import scala.reflect.runtime.universe._

show {
  reify {
    for (p <- persons; if !p.isMale; c <- p.children)
      yield (p.name, c.name)
  }
}

// common interface
trait C[A] {
  def map[B](f: A => B): C[B]
  def flatMap[B](f: A => C[B]): C[B]
  def filter(p: A => Boolean): C[A]
  def foreach(b: A => Unit): Unit
}

// also Option
val a, b, c = Option(1)
for {
  i <- a
  j <- b
  ij = i + j
  k <- c
} yield (ij + k)

a.flatMap {
  i => b.map { j => (j, i + j) }.flatMap {
    case (j, ij) => c.map {
      k => ij + k }}}

// also Either (projections only)
val either1 = Right[String, Int](1)
val either2 = Left[String, Int]("err")
for {
  e1 <- either1.right // Either.RightProjection
  e2 <- either2.right // Either.RightProjection
} yield e1

// Try
import scala.util.Try
val result = for (
  v <- Try("5".toInt);
  k <- Try("6".toInt);
  z <- Try("9".toInt)
) yield( v + k + z)

