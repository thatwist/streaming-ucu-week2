package ua.edu.ucu.graded.bank.repository

import scala.util.Try

trait Repository[A, IdType] {
  def query(id: IdType): Try[Option[A]]
  def store(a: A): Try[A]
}
