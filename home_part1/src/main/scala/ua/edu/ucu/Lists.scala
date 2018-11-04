package ua.edu.ucu

object Lists {
  // #0
  //  Define max function in terms of 'reduce' function on List
  def max(xs: List[Int]): Int = ???

  //  Following functions should be generic defined for arbitrary types

  // #1
  //  Rotate a list N places to the left.
  // Examples:
  //  rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  //  rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  ???

  // #2
  //  Flatten a nested list structure.
  //  Use for-comprehension
  // Example:
  //  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  //  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  ???

  // #3
  //  Eliminate consecutive duplicates of list elements.
  //  If a list contains repeated elements they should be replaced with a single copy of the element.
  //  The order of the elements should not be changed.
  // Example:
  //  compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  ???

  // #4
  //  Pack consecutive duplicates of list elements into sublists.
  //  If a list contains repeated elements they should be placed
  //  in separate sublists.
  // Example:
  //  pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  ???

  // #5
  //  Run-length encoding of a list.
  //  Use the result of a previous problem to implement the so-called
  //  run-length encoding data compression method.
  //  Consecutive duplicates of elements are encoded as Tuples (N, E)
  //  where N is the number of duplicates of the element E.
  // Example:
  //  encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  // res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  ???

  // #6
  //  Modified run-length encoding.
  //  Modify the result of previous problem in such a way
  //  that if an element has no duplicates it is simply copied
  //  into the result list.
  //  Only elements with duplicates are transferred as (N, E) terms.
  // Example:
  //  encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  ???

  // #7
  //  Decode a run-length encoded list.
  //  Given a run-length code list generated as specified in problem #5, construct its uncompressed version.
  // Example:
  //  decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  //  res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  ???


  // #8
  //  Sorting a list of lists according to length of sublists.
  //  a) We suppose that a list contains elements that are lists themselves.
  //     The objective is to sort the elements of the list according to their
  //     length. E.g. short lists first, longer lists later, or vice versa.
  //     Example:
  //       lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
  //       res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
  //  b) Again, we suppose that a list contains elements that are lists
  //     themselves. But this time the objective is to sort the elements
  //     according to their length frequency; i.e. in the default, sorting is
  //     done ascendingly, lists with rare lengths are placed, others with a more
  //     frequent length come later.
  //     Example:
  //       lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
  //       res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
  //     Note that in the above example, the first two lists in the result
  //     have length 4 and 1 and both lengths appear just once.
  //     The third and fourth lists have length 3 and there are two
  //     list of this length. Finally, the last three lists have length 2.
  //     This is the most frequent length.
  //   HINTS: you can use encode method from #5 assignment, and build a Map of frequencies and then use that map later.
  //     Remember, that Map is built using series of tuples of arity 2 (`a -> b` or `Tuple2(a, b)` or just `(a, b)`)
  //     you can use .swap method on tuple of 2 to swap two values in it (`(b, a)`)
  ???
}