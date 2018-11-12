package ua.edu.ucu.graded

import java.util.{Calendar, Date}

package object bank {
  type Amount = BigDecimal
  val today: Date = Calendar.getInstance.getTime
}
