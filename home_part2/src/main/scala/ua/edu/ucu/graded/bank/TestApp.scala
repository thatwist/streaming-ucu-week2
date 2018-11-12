package ua.edu.ucu.graded.bank

import ua.edu.ucu.graded.bank.model.Account
import ua.edu.ucu.graded.bank.repository.AccountRepositoryInMemory
import ua.edu.ucu.graded.bank.service.AccountServiceImpl

import scala.util.Try

object TestApp extends App {

  val repository = new AccountRepositoryInMemory
  val service = new AccountServiceImpl(repository)

  def test(no: String) = for {
    _ <- service.credit(no, BigDecimal(100))
    _ <- service.credit(no, BigDecimal(300))
    _ <- service.debit(no, BigDecimal(160))
    b <- service.balance(no)
  } yield b


  def transferTest(
    from: String,
    to: String,
    amount: Amount
  ): Try[(Account, Account, Amount)] = {
    for {
      a <- service.debit(from, amount)
      b <- service.credit(to, amount)
    } yield (a, b, amount)
  }

  val no1 = "a3c1"
  val no2 = "b2a5"
  service.open(no1, "test1", Some(today))
  service.open(no2, "test2", Some(today))
  transferTest(no1, no2, 10000)
  test(no1)

}
