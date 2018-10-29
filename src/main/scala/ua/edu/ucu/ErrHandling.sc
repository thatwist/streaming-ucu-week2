
import scala.util.{Failure, Success, Try}

//  given implementation of List's 'last' function, add error handling to it using Options

def last(l: List[Int]): Either[String, Int] = {
  l match {
    case Nil => Left("error")
    case head :: Nil => Right(head)
    case _ :: tail => last(tail)
  }
}



