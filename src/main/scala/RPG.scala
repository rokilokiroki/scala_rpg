import scalaz.std.option

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

    println("自分の星座を入力してください")
    val constellation:String = io.StdIn.readLine()
//    val c = constellation.getClass
//    println(c)
    if (constellation.isEmpty()) {
      println("自分の星座を入力してください")
      val constellation:String = io.StdIn.readLine()
      println(constellation)
      val option_c: Option[String] = Option(constellation)
      println(option_c)
//      var b = option_c.isEmpty
//      println(b)
      val constellation_result: String = option_c match {
        case Some(constellation) => constellation
        case None => "なし"
      }
    }
//    val option: Option[String] = Option(null)
//    val result = option.orNull
//    println(result)
    val yuusha = new Yuusha(firstname,lastname)
    val a = firstname.size
    val sword_skill = yuusha.getSwordSkill(a)
    val constellation_skill = yuusha.getSkillByConstellation(constellation)
    println(sword_skill(0),sword_skill(1))

    val characterFactory = CharacterFactory.create()
    println(characterFactory.attack)
    val Points = Map(
      "HP" -> firstname.length,
      "MP" -> lastname.length
    )
    val slime = Monster.apply("slime","mera")
    val metalslime = slime.copy("metalslime", "merami")
    slime.printSkill()
    metalslime.printSkill()
    yuusha.walk()
    yuusha.attack()
    yuusha.HP = yuusha.getHP(Points.get("HP"))
    yuusha.MP = yuusha.getMP(Points.get("MP"))
    val c = new Call
    c.battle
  }


}