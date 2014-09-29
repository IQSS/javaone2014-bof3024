:paste
/*
Companion to JavaOne-2014: BOF-3024: Learning Scala: A Practical Approach

Use this file by loading it from the Scala REPL:
scala> :load CaseClasses.scala
*/

abstract class Session

case class BOF(num:Int, title:String) extends Session
case class Tutorial(num:Int, technology:String) extends Session
case class Keynote( title:String, speaker:String ) extends Session
case class JUG( groupName: String ) extends Session

val jos = BOF(3024,"Learning Scala the Practical Way")
val jos2 = jos.copy( num = 1024 )

object SessionPrinter {
  def print(s:Session)={
    s match {
      case BOF(n,t) => "%d: BOF %s".format(n,t)
      case Tutorial(n,t) => "Learn about %s! (%d)".format(t,n)
      case JUG(g) => "Meet with friends from %s".format(g)
      case _ => s.toString
    }
  }
}