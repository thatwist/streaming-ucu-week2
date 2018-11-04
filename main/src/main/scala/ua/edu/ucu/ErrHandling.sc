
import scala.util.{Failure, Success, Try}

//  given implementation of List's 'last' function, add error handling to it using Options

def last(l: List[Int]): Either[String, Int] = {
  l match {
    case Nil => Left("error")
    case head :: Nil => Right(head)
    case _ :: tail => last(tail)
  }
}


val s = 1
val e = 2
val ll = s <= e


def thr() = {
  throw new Exception
}

Try(thr()) match {
  case Failure(e: IllegalArgumentException) => println("test")
  case Failure(e: Exception) => throw e
  case _ => println("fail")
}


def toList[A](a: A) = List(a)

def foo[A](f: A => List[A], i: Int) = f(i)