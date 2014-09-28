:paste
/*
Companion to JavaOne-2014: BOF-3024: Learning Scala: A Practical Approach

Use this file by loading it from the Scala REPL:
scala> :load Object.scala
*/

object Counter {
  var count = new java.util.concurrent.atomic.AtomicInteger(0)
  def up() = count.addAndGet(1)
  def down() = count.addAndGet(-1)
  def value = count.get
}

class Burrito private( val filling:String ) {
  override def toString() = "Burrito with " + filling
}

object Burrito {
  var count = new java.util.concurrent.atomic.AtomicInteger(0)
  def makeWith( filling:String ) = {
    count.incrementAndGet()
    new Burrito(filling)
  }
  def apply( filling:String ) = makeWith(filling)
  
  def brag() = "%,d burritos served".format(count.get)
}