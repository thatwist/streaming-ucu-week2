// initialized on first access
lazy val foo = {
  println("init")
  "bar"
}
foo
// init
// res0: String = bar
foo
// res1: String = bar



object Demo {
  val x = { println("initializing x"); "done" }
}
Demo
// initializing x
Demo.x
// res20: java.lang.String = done



trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = numer +"/"+ denom
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
val x = 2  // x: Int = 2

new LazyRationalTrait {
  val numerArg = 1 * x
  val denomArg = 2 * x
}  // res1: java.lang.Object with LazyRationalTrait = 1/2


