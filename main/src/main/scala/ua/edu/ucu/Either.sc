object EitherLeftRightExample extends App {

  /**
    * A simple method to demonstrate how to declare that a method returns an Either,
    * and code that returns a Left or Right.
    */
  def divideXByY(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Dude, can't divide by 0")
    else Right(x / y)
  }

  // a few different ways to use Either, Left, and Right
  println(divideXByY(1, 0))
  println(divideXByY(1, 1))
  divideXByY(1, 0) match {
    case Left(s) => println("Answer: " + s)
    case Right(i) => println("Answer: " + i)
  }
}

val either1: Either[String, Int] = Right(1)
val either2: Either[String, Int] = Left("err")

for {
  e1 <- either1.left
  e2 <- either2.left
} yield e2

either1.flatMap(e1 => either2.map(e2 => e2))


for {
  o1 <- Some(1)
  o2 <- None
} yield o2


