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
//Greeter.greet("Joe")

import JoesPrefs._
Greeter.greet("Joe")
//  Welcome, Joe. The system is ready.
//  Yes, master>

implicitly[PreferredPrompt]
