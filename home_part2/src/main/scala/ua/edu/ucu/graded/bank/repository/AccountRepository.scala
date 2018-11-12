package ua.edu.ucu.graded.bank.repository

import java.util.Date

import ua.edu.ucu.graded.bank.model.{Account, Balance}

import collection.mutable.{Map => MMap}

trait AccountRepository extends Repository[Account, String] {
  def query(no: String): Account // TODO - Try[Option[Account]]
  def store(a: Account): Account // TODO - Try[Account]
  def balance(no: String): Balance = { // TODO - Try[Balance]
    // TODO
    // query(no) - fail if not found, return account.balance if Ok
    ???
  }
  def query(openedOn: Date): Seq[Account] // TODO Try[Seq[Account]]
}

class AccountRepositoryInMemory extends AccountRepository {
  lazy val repo: MMap[String, Account] = MMap.empty[String, Account]

  def query(no: String): Account = {
    // TODO - get from repo
    ???
  }
  def store(a: Account): Account = {
    // TODO - store to repo
    ???
  }
  def query(openedOn: Date): Seq[Account] = {
    // TODO - find with corresponding opnendOn date in repo
    ???
  }
}

