:paste
/*
Companion to JavaOne-2014: BOF-3024: Learning Scala: A Practical Approach

Use this file by loading it from the Scala REPL:
scala> :load Rewrite.scala
RewriteSample.html2(input)
*/
import scala.collection.mutable

val input = Seq(" hello    ", " world     ", "* bullet1 ", "* bullet2", "* bullet3", "world", "hello")

object RewriteSample {

  def html1( rawStrings : Seq[String] ):String = {
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
    return html.mkString
  }

  def html2( rawStrings : Seq[String] ) = {
    val cleaned = rawStrings.map( _.trim )

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
    html.mkString
  }

  def html3( rawStrings : Seq[String] ) = {
    val elements = rawStrings.map( _.trim )
                             .map( s => if (s.startsWith("*")) {"<li>"+s.substring(1).trim+"</li>"}
                                          else {"<p>" + s + "</p>"} )

    val grouped = elements.tail.foldLeft( List(List(elements.head)) )(
                     (l,s)=> { if ( l.last.head(1) != s(1) ) l :+ List(s) else l.dropRight(1) :+ (l.last :+ s) })

    grouped.flatMap( l => if (l.head.startsWith("<li>")) List("<ul>"+l.mkString+"</ul>") else l ).mkString
  }
}