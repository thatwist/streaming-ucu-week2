// #0
/*
 Following function calculates the largest palindrome from an n-digit number using higher order functions.
 Rewrite it using for-comprehension */
def largestPalindromeWithHigherOrderFunctions(amountOfDigits: Int): Int = {
  require(amountOfDigits > 1, "amount of digits must be at least 2")
  val fromNumber = Math.pow(10, amountOfDigits - 1).toInt
  val toNumber = Math.pow(10, amountOfDigits).toInt - 1
  (fromNumber to toNumber).flatMap(i => i to toNumber map (j => i * j))
    .filter(prod ⇒ prod.toString == prod.toString.reverse)
    .max
}
def largestPalindromeWithForComp(amountOfDigits: Int): Int = ???
largestPalindromeWithHigherOrderFunctions(4)
largestPalindromeWithForComp(4)
// You can use show reify (refer to slides) to inspect how compiler rewrites the comprehension

// Books
case class Book(title: String, authors: List[String])
// small example database:
val books: List[Book] = List(
  Book("Structure and Interpretation of Computer Programs",
    List("Abelson, Harold", "Sussman, Gerald J.")),
  Book("Principles of Compiler Design",
    List("Aho, Alfred", "Ullman, Jeffrey")),
  Book("Programming in Modula-2",
    List("Wirth, Niklaus")),
  Book("Introduction to Functional Programming",
    List("Bird, Richard")),
  Book("The Java Language Specification",
    List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")))
// #1
/*
 Find the titles of all books whose author’s last name is "Ullman" using for-comprehensions*/
???

// #2
/*
 Using for-comprehension, find the names of all authors that have written at least two books in the above database.*/
???

