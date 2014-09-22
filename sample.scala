:paste
import scala.collection.mutable

val input = Seq(" hello    ", " world     ", "* bullet1 ", "* bullet2", "* bullet3", "world", "hello")

object Sample {

  def html1( rawStrings : Seq[String] ):Seq[String] = {
    val cleaned = mutable.Buffer[String]()
    for ( l <- rawStrings ) {
      cleaned += l.trim
    }
    val curUl = mutable.Buffer[String]()
    val html = mutable.Buffer[String]()
    for ( l <- cleaned ) {
      if ( l.startsWith("*") ) {
        curUl += "<li>" + l.substring(1).trim + "</li>"
      } else {
        if ( ! curUl.isEmpty ) {
          html += "<ul>"+curUl.mkString + "</ul>"
          curUl.clear
        }
        html += "<p>" + l + "</p>"
      }
    }
    
    if ( ! curUl.isEmpty ) {
      html += "<ul>"+curUl.mkString + "</ul>"
    }
    return html
  }
}