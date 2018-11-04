import scala.collection.immutable.Stream.cons

// simple stream:
val stream1 = 1 #:: 2 #:: 3 #:: Stream.empty
println(stream1)

// alternative notation:
val stream2: Stream[Int] = cons(1, cons(2, cons(3, Stream.empty)))

// infinite stream:
def inifiniteNumberStream(number: Int): Stream[Int] = Stream.cons(number,
  inifiniteNumberStream(number + 1))
inifiniteNumberStream(1).take(20).print

// stream of all squares:
val squares = Stream.from(1).map(x => x * x)
squares.take(10).print()

// primes:
def primeStream(s: Stream[Int]): Stream[Int] =
  s.head #:: primeStream(s.tail filter(_ % s.head != 0))
val primes = primeStream(Stream.from(2))
primes.take(10).print

// fib
def fibFrom(a: Int, b: Int): Stream[Int] = ???
val fibs = fibFrom(1,1)
