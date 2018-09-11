trait Human {
  var HP:Int
  var MP:Int
  def walk(): Unit ={
    println("歩く")
  }

  def escape(): Unit ={
    println("逃げます")
  }
}
