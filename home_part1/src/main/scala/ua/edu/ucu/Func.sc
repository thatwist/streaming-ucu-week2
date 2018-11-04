// #0
// This function, partial1, takes a value and a function of two arguments,
// and returns a function of one argument as its result.
// The name comes from the fact that the function is being applied to some but not all of its required arguments.
//  Implement partial1
def partial1[A, B, C](a: A, f: (A, B) => C): B => C = ???

// #1
// currying, converts a function of N arguments into a function of one argument
// that returns another function as its result
def curry[A, B, C](f: (A, B) => C): A => (B => C) = ???

// #2
// Implement uncurry, which reverses the transformation of curry.
// Note that since => associates to the right, A => (B => C) can be written as A => B => C
def uncurry[A, B, C](f: A => B => C): (A, B) => C = ???

// #3
// Implement the higher-order function that composes two functions.
def compose[A, B, C](f: B => C, g: A => B): A => C = ???

// #4
// Implement partial function which returns values only for a positive integers
val sqrt: PartialFunction[Int, Double] = ???
sqrt.isDefinedAt(-1) // false

// #5
// Implement function which filters input and returns wrapped number only when its even
val even: Int => Option[Int] = ???
val evenPF: PartialFunction[Int, Int] = Function.unlift(even)
// Define a List of values from 1 to 100, use .collect function on it
// and definitions above to collect only even numbers
???
