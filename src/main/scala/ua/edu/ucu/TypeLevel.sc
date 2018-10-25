
type ListInt = List[Int]
type MapIntString = Map[Int, String]


trait Queue[T]{ // more generic than IntQueue
  def get:T
  def put(x:T)
}

trait Queue1{ // more generic than IntQueue
  type T
  def get:T
  def put(x:T)
}
