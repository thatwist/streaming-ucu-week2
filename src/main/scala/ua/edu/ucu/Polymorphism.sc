trait IntQueue {
  def get:Int
  def put(x:Int)
}

def head[A](xs: List[A]): A = xs(0)
// head: [A](xs: List[A]) => A

head(1 :: 2 :: Nil)
// res0: Int = 1

case class Car(make: String)
// defined class Car

head(Car("Civic") :: Car("CR-V") :: Nil)
// res1: Car = Car(Civic)