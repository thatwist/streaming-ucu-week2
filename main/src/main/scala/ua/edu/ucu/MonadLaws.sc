// Monad laws
// List

// Let f be a function that takes an Int and produces a List of its
// neighboring Ints along with itself:
val f1: (Int => List[Int]) = x => List(x - 1, x, x + 1)

// Let g be a function that takes an Int x
// and produces a List containing +x and -x
val g1: (Int => List[Int]) = x => List(x, -x)

// Left identity
val a = 2
val lhs1 = List(a).flatMap(f1)
val rhs1 = f1(a)
lhs1 == rhs1

// Right identity
val m1 = List(2)
val lhs2 = m1.flatMap(List(_)) // unit
val rhs2 = m1
lhs2 == rhs2

// Associativity
val m2 = List(1, 2)
val lhs3 = m2.flatMap(f1).flatMap(g1)
val rhs3 = m2.flatMap(x => f1(x).flatMap(g1))
lhs3 == rhs3


