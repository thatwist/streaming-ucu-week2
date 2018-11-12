package ua.edu.ucu.graded.bank.model

import java.util.Date

import ua.edu.ucu.graded.bank._

case class Balance(amount: Amount = 0)

case class Account(
  no: String,
  name: String,
  dateOfOpening: Date = today,
  dateOfClosing: Option[Date] = None,
  balance: Balance = Balance())

