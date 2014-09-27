:paste
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