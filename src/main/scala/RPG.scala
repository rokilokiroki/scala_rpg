import java.io.{BufferedReader, File, FileReader}

import scala.collection.immutable.Map

object RPG {

  def main(args: Array[String]): Unit = {
    println("勇者の名前を入力してください")
    val name = io.StdIn.readLine()

    if (name.isEmpty()) {
      println("勇者の名前を入力してください")
      val name = io.StdIn.readLine()
    }
    val character = new Character
    val yuushaName = if (name != null){
      name.split(' ')
    } else {
      sys.exit
    }

    val firstname:String = yuushaName(0)
    val lastname: String = yuushaName.lift(1) match {
      case Some(lastname) => lastname
      case None => sys.exit()
    }
    val yuusha = new Yuusha(firstname,lastname)
    val characterFactory = CharacterFactory.create()
    println(characterFactory.attack())
    val elements = Map(
      "HP" -> firstname.length(),
      "MP" -> lastname.length()
    )
    val slime = Monster.apply("slime","mera")
    val metalslime = slime.copy("metalslime", "merami")
    slime.printSkill()
    metalslime.printSkill()
    yuusha.walk()
    yuusha.attack()
    yuusha.HP = yuusha.getHP(elements.get("HP"))
    yuusha.MP = yuusha.getMP(elements.get("MP"))
  }

}