trait Command {
  val receiver:Receiver = new Receiver
  def battle(): Unit ={
  }
}

class BattleCommand extends Command {
}

class Fight extends BattleCommand{
  override def battle(): Unit = {
    receiver.battle_fight()
  }
}

class Magic extends BattleCommand{
  override def battle(): Unit = {
    receiver.battle_magic()
  }
}


class Receiver {
  def battle_fight(): Unit ={
    println("fight")
  }

  def battle_magic(): Unit ={
    println("magic")
  }
}

class Invoker{
  def fight(): Unit ={
    val action = new Fight
    this->battle(action)
  }

  def magic(): Unit ={
    val action = new Magic
    this->battle(action)
  }

  private def battle(action:BattleCommand): Unit ={
    action.battle
  }
}

class Client(){
  val invoker: Invoker = new Invoker
  def fight(): Unit ={
    invoker.fight()
  }

  def magic(): Unit ={
    invoker.magic()
  }
}

class Call{
  val battle = new Client
  battle.fight()
  battle.magic()
}
