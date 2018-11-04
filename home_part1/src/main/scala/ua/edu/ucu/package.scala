package ua.edu

package object ucu {

  def loadDictionary: List[String] = {
    val words = Option {
      getClass.getResourceAsStream("words.txt")
    } getOrElse {
      sys.error("Could not load word list, dictionary file not found")
    }
    try {
      val s = io.Source.fromInputStream(words)
      s.getLines.toList
    } catch {
      case e: Exception =>
        println("Could not load word list: " + e)
        throw e
    } finally {
      words.close()
    }
  }

}
