package ua.edu.ucu.graded.bank.repository

trait Repository[A, IdType] {
  def query(id: IdType): A // TODO Try[Option[A]]
  def store(a: A): A // TODO Try[A]
}
