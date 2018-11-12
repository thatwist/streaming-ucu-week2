package ua.edu

import java.io.File

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

  def resourceAsStream(resource: String): Option[java.io.InputStream] = {
    val classesDir = new File(getClass.getResource(".").toURI)
    val projectDir = classesDir.getParentFile.getParentFile.getParentFile.getParentFile.getParentFile.getParentFile
    val resourceFile: File = ("src" :: "main" :: "resources" :: resource :: Nil)
      .foldLeft(projectDir)((file, child) => new File(file, child))
    if (resourceFile.exists) Some(new java.io.FileInputStream(resourceFile)) else None
  }

}
