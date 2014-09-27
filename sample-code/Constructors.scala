:paste
/*
Companion to JavaOne-2014: BOF-3024: Learning Scala: A Practical Approach

Use this file by loading it from the Scala REPL:
scala> :load Constructors.scala
*/
class Bof( var title:String,
           val num:Int,
           topic: String ) {
  def desc = title + ", a BOF about " + topic

  def this( title:String ) = {
    this( title, title.size, "the topic of '%s'".format(title))
  }
}