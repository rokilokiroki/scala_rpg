import java.io.{BufferedReader, FileReader}

import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._


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

  def getSwordSkill(): Unit ={

    val sword_skills = JsoupBrowser().get("https://www43.atwiki.jp/medakabox/pages/194.html")
    val line:List[List[String]] = for {skills <- sword_skills >> elementList("table > tbody > tr")
         line:List[String] = (skills >> elementList("td")).map(_.text)
//         skill <- line
    }yield { line }

//    val sword = for(i <- 0 to skill.size; if i % 2 != 0)yield{
//          skill(i)
//    }
//    val sword:List[String] = for {i <- 0 to line.size
//      l:List[String] =
//    }
//
//    println(sword)
//    val sword = for {
//      s <- skill
//      i <- 0 to skill.size
//      a = if (i % 2 != 0) {
//        skill(i)
//      }
//    }yield{ a }

  }

  def getCombatSkill(): Unit ={
    val combat_skills = JsoupBrowser().get("https://www43.atwiki.jp/medakabox/pages/195.html")
    for {skills <- combat_skills >> elementList("table > tbody > tr")
         line:List[String] = (skills >> elementList("td")).map(_.text)
         skill = line(1)
         explain = line(2)
    }println(s"$skill - $explain")
  }

  def getMagicSkill(): Unit ={
    val magic_skills = JsoupBrowser().get("https://www43.atwiki.jp/medakabox/pages/196.html")
    for {skills <- magic_skills >> elementList("table > tbody > tr")
         line:List[String] = (skills >> elementList("td")).map(_.text)
         skill = line(1)
         explain = line(2)
    }println(s"$skill - $explain")
  }

  def getGunSkill(): Unit ={
    val gun_skills = JsoupBrowser().get("https://www43.atwiki.jp/medakabox/pages/200.html")
    for {skills <- gun_skills >> elementList("table > tbody > tr")
         line:List[String] = (skills >> elementList("td")).map(_.text)
         skill = line(1)
         explain = line(2)
    }println(s"$skill - $explain")
  }

  def getHeroSkill(): Unit ={
    val hero_skills = JsoupBrowser().get("https://www43.atwiki.jp/medakabox/pages/200.html")
    for {skills <- hero_skills >> elementList("table > tbody > tr")
         line:List[String] = (skills >> elementList("td")).map(_.text)
         skill = line(1)
         explain = line(2)
    }println(s"$skill - $explain")
  }

}