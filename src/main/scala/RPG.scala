import scala.collection.immutable.Map

object RPG {

  def main(args: Array[String]): Unit = {
    val character = new Character
    println("勇者の名前を入力してください")
//    try {
//      val name = io.StdIn.readLine()
//    } catch {
//      e: ArrayIndexOutOfBoundsException
//      sys.exit
//    } finally {
//      in.close()
//    }
    val name = io.StdIn.readLine()
    val yuushaName = if (name != null){
      name.split(' ')
    } else {
      sys.exit
    }
    val firstname = yuushaName(0)
    val lastname = yuushaName(1)
    val yuusha = new Yuusha(firstname,lastname)
    val elements = Map(
      "HP" -> firstname.length(),
      "MP" -> lastname.length()
    )
    yuusha.walk()
    yuusha.attack()
    yuusha.HP = yuusha.getHP(elements.get("HP"))
    yuusha.MP = yuusha.getMP(elements.get("MP"))
    println(yuusha.die)
    println(character.talent)
  }

}