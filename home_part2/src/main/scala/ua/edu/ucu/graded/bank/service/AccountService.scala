package ua.edu.ucu.graded.bank.service

import java.util.Date

import ua.edu.ucu.graded.bank.{Amount, _}
import ua.edu.ucu.graded.bank.model.{Account, Balance}
import ua.edu.ucu.graded.bank.repository.AccountRepository

trait AccountService[Account, Amount, Balance] {

  def open(no: String, name: String, openingDate: Option[Date]): Account // TODO - Try

  def close(no: String, closeDate: Option[Date]): Account // TODO - Try

  def debit(no: String, amount: Amount): Account // TODO - Try

  def credit(no: String, amount: Amount): Account // TODO - Try

  def balance(no: String): Balance // TODO - Try
}

class AccountServiceImpl(
  repo: AccountRepository
) extends AccountService[Account, Amount, Balance] {

  def open(no: String, name: String, openingDate: Option[Date]): Account = {
    val a = repo.query(no)
    if (no.isEmpty || name.isEmpty) ???
    else if (openingDate.getOrElse(today) before today) ???
    else ???
  }

  def close(no: String, closeDate: Option[Date]): Account = {
    val a = repo.query(no)
    if (closeDate.getOrElse(today) before a.dateOfOpening) ???
    else ???
  }

  def debit(no: String, amount: Amount): Account = {
    // TODO
    // query repo for account 'no', fail if its not found
    // fail if balance amount on account less then amount argument(of this function)
    // otherwise store into a repo an updated account with reduced balance
    ???
  }

  def credit(no: String, amount: Amount): Account = {
    // TODO
    // query account 'no' from repo
    // store updated account with increased balance
    // (remember about case class copy)
    ???
  }

  def balance(no: String): Balance = {
    // TODO
    // query repository
    ???
  }

}

