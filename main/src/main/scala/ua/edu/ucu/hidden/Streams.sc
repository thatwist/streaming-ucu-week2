def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
val fibs1 = fibFrom(1,1)

lazy val fibs: Stream[Long] = 0L #:: 1L #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

