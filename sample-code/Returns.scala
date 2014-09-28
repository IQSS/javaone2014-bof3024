:paste
/*
Companion to JavaOne-2014: BOF-3024: Learning Scala: A Practical Approach

Use this file by loading it from the Scala REPL:
scala> :load Returns.scala
*/
class SumWithUnit {
  var sum = 0
  def add(b: Int): Unit ={
     sum += b
     return ()
  }
  def add1( i:Int ) {
    sum += i
    ()
  }
  def add2( i:Int ) = {
    sum += i
  }
  def add3( i:Int ) = sum += i
}

class SumWithInt {
  var sum = 0
  def add(b: Int):Int={
    sum += b
    return sum
  }

  def add1( i:Int )={
    sum += i
    sum
  }  
}