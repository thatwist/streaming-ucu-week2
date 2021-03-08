
  // Basic material - call by name, call by value, currying, compose, andThen

  // Base - add error handling by options in monadic way
  // Base - work with generics, traverse tree
  // ? implementing the List

  // Advanced - define monad instance and work with that


  // Advanced Material: Scalaz, Cats docs

  // Ex: operations on trees, generic trees
  // Ex: implement generic set implementation using this tree structure
  //     apply constructor
  //     implicit conversions from other types (from regular set?)
  // Ex: unit-testing - get into ScalaTest simple tests


  // give additional material, additional tasks
  // type-class pattern
  // implement a monad/functor for some specific structure,
  // implement EitherMonad


  // Ex: Rational as a function
  // Ex: implicit class on Int to redefine '/' operator
  // Ex: Apply method?

  def calc(l: List[String]): Int = l match {
    case a :: Nil => a.toInt
    case a :: "+" :: tail => a.toInt + calc(tail)
    case a :: "*" :: b :: tail => calc(s"${a.toInt * b.toInt}" :: tail)
  }

  calc(List("1", "+", "2", "*", "3"))