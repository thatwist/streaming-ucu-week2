import scala.util.Try

// TODO: define safe error handled implementation of converting String to Int
def toInt(s: String): Option[Int] = ???

// TODO: define same but with Try data type
def tryInt(s: String): Try[Int] = ???

// TODO: define same but with Either with String error on the left
def eitherInt(s: String): Either[String, Int] = ???

val resultOpt = for {
  i1 <- toInt("1")
  i2 <- toInt("2")
  i3 <- toInt("3")
} yield i1 + i2 + i3

val resultTry = for {
  i1 <- tryInt("1")
  i2 <- tryInt("2")
  i3 <- tryInt("3")
} yield i1 + i2 + i3

val resultEither = for {
  i1 <- eitherInt("1").right
  i2 <- eitherInt("2").right
  i3 <- eitherInt("3").right
} yield i1 + i2 + i3

// TODO - output above either result properly
def printEither
