class PreferredPrompt(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt) {
    println("Welcome, "+ name +". The system is ready.")
    println(prompt.preference)
  }
}

val bobsPrompt = new PreferredPrompt("relax> ")
Greeter.greet("Bob")(bobsPrompt)
//Welcome, Bob. The system is ready.
//relax>

// define implicit value:
object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
}
//Greeter.greet("Joe")
// error: no implicit argument matching parameter PreferredPrompt was found.

import JoesPrefs._

// =========== implicit lookup ========
// here compiler will look for a value in the scope with the same (or sub) type
// it will look into local scope, then into imports, companion objects, global scope, ..
Greeter.greet("Joe")
//  Welcome, Joe. The system is ready.
//  Yes, master>

//======== implicitly ===========
// this is simply a method to 'fetch' the particular implicit of type in the scope
// convenient when debugging and using context bounds (see later)
implicitly[PreferredPrompt]

//======== implicit conversions =========
import scala.language.implicitConversions
implicit def str2PreferredPromt(s: String): PreferredPrompt = new PreferredPrompt(s)

// it is converted into PreferredPromt:
"test".preference

//======== implicit class =========
// here we extend List functionality with additional method
// this pattern used a lot - it is another example of ad-hoc polymorphism
implicit class ListOps[A](l: List[A]) {
  def secondEl: Option[A] = l.tail.headOption
}

List(1, 2, 3).secondEl
