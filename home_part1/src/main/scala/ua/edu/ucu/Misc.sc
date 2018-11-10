// #0
//  Create a function to generate a Map of numbers
//  from a to b with its string representation.
//  e.g. 1 -> "1", 2 -> "2", ..
//  transform a given Map to have interchanged value-key pairs. ("1"->1, and so on)

// #1
//  Count words in a file. You can use scala.io.Source.fromFile("") function
//  to read contents of the file. To split a String into words use `.split("\\W+")`
//  You should return an immutable map containing word as a key and number as a count.
//

val source = scala.io.Source.fromURL(getClass.getResource("/example.txt"))

???