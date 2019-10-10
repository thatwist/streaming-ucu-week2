object Implicits {
  import scala.language.implicitConversions
  implicit def str2Int(s: String): Int = java.lang.Integer.parseInt(s)
}

import Implicits._

"1" > "2"