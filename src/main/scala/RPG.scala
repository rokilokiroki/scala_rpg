import java.io.{BufferedReader, File, FileReader}

import scala.collection.immutable.Map

object RPG {

  def main(args: Array[String]): Unit = {
    println("勇者の名前を入力してください")
    val name = io.StdIn.readLine()

    if (name.isEmpty()) {
      println("入力してください")
      sys.exit
    }


    val character = new Character


    //    try {
//      //val name = io.StdIn.readLine()
//    }
//    catch {
//      case e: ArrayIndexOutOfBoundsException => {
//        sys.exit
//      }
//    }

//    def toIntOption( s:String ):Option[Int] = try{ Some( s.toInt ) } catch { case _ =>None }
//    val n = toIntOption( "foo" ) getOrElse( -1 )
//    println(n)


//
//    def inputNameOfYuusya(readline:String): Option[String] =
//      try {
//        Some(readline)
//      }
//      catch {
//        case _ => None
//      }
//
//    val readline = io.StdIn.readLine()
//    val name = inputNameOfYuusya(readline)getOrElse("名前無し")





//    println(name)
//    val name = io.StdIn.readLine()
    val yuushaName = if (name != null){
      name.split(' ')
    } else {
      sys.exit
    }
    val firstname = yuushaName(0)
    val lastname = yuushaName(1)

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
    println(yuusha.die())
    println(character.talent())
    println(yuusha.getSKILL())
  }

}