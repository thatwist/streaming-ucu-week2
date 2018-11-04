// Function definition
val f1: Int => String = _.toString
// equivalent to:
val f2: Function1[Int, String] = _.toString

// Function application
f2(1)
// equivalent to:
f2.apply(1)

// Higher-order functions:
val plusOne = (x:Int) => x + 1
val nums = List(1,2,3)
// map takes a function: Int => T
nums.map(plusOne)     // List(2,3,4)
// Inline Anonymous
nums.map(x => x + 1)  // List(2,3,4)
// Short form
nums.map(_ + 1)       // List(2,3,4)

// HOF on List
val list = List(1,2,3,4)
// A few more examples for List class
list.exists(_ == 2)         // true
list.find(_ == 2)           // Some(2)
list.indexWhere(_ == 2)     // 1
list.reduceLeft(_ + _)      // 10
list.foldLeft(100)(_ + _)   // 110
// Many more in collections library

// functions as parameters
def each(xs: List[Int], fun: Int => Unit) {
  if(!xs.isEmpty) {
    fun(xs.head)
    each(xs.tail, fun)
  }
}
each(List(1,2,3), println)

// currying
def nDividesM(m : Int)(n : Int) = n % m == 0
// nDividesM: (m: Int)(n: Int) Boolean
val isEven = nDividesM(2)_
// isEven: Int => Boolean = <function1>
println(isEven(4))
true

// composition
val option = Some(1)
val f: Int => String = _.toString
val g: String => Int = _.toInt
option.map(f).map(g)
option.map(f andThen g)
option.map(g compose f)

val fg = (x: Int) => g(f(x))
val fg_ = g compose f

// partial application
def add(a:Int, b:Int) = a +b
val fn = add(2,_:Int) // returns a function
fn(2) // returns 4!
