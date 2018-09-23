import java.io.{BufferedReader, FileReader}
class Character extends Human with Aggressive {
  override var HP: Int = 10
  override var MP: Int = 10
  var SEX :String = _
  def attack(): Unit ={
    println("攻撃します")
  }
  def magic(): Unit ={
    println("魔法を使います")
  }

}

class Yuusha(val firstname: String, val lastname: String) extends Character {
  def getHP (HP: Option[Int]) = {
      HP match {
        case Some(hp) =>
          hp * 100
        case None =>
          sys.exit
      }
    }


  def getMP (MP: Option[Int]) =
    {
      MP match {
        case Some(mp) =>
          mp * 100
        case None =>
          sys.exit
      }
    }

  def getSKILL() ={
    var reader = new BufferedReader( new FileReader("./src/main/scala/Skill.txt") )
    var skill:String = null
    val skillList = new collection.mutable.ListBuffer[String]
    while( { skill = reader.readLine; skill != null } ) {
      skillList.append(skill)
    }
    reader.close
    println(skillList.head)
  }

}