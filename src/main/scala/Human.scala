trait Human extends Creature{
  var HP:Int
  var MP:Int
  def walk(): Unit ={
    println("歩く")
  }

  def escape(): Unit ={
    println("逃げます")
  }
}

trait Creature {
  def die(): Unit ={
    println("生きていれば必ず死ぬ")
  }
}

trait Aggressive {
  def talent(): Unit ={
    println("積極的な人間")
  }
}

