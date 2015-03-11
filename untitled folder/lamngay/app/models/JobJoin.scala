package models

import scala.slick.driver.PostgresDriver.simple._
import play.api.Play.current

/**
 * Created by tuanna on 5/29/14.
 */
case class JobJoin(jobname: String,employername: String)

object JobJoin{
  val jobs=Jobs
  val employers=Employers
  val jobLocation = JobLocation
  val jobSkill = JobSkill
  val skill= Skills
  val locations= Locations

  def find(implicit s: Session) :List[String] = {

     (for ( c <- jobs) yield c.name).list

  }
 def findAll(implicit s: Session) :List[(String,String,Option[String],Option[String])]={
  val skillInnerJoinJobSkill = for {
    s <- Skills
    j <- jobSkill if j.skillid===s.id
  } yield (s.name,j.jobid)

   val locationsInnerJoinJobLocation = for {
     l <- locations
     j <- jobLocation if j.locationid === l.id
   } yield (l.name,j.jobid)

   val implicitInnerJoin = for {
    c <- jobs
    s <- employers if c.employerid === s.id
//    js <- skillInnerJoinJobSkill if js._2 === (c.id).toLong
//    l <- locationsInnerJoinJobLocation if l._2 === (c.id).toLong
  } yield (c.name, s.name,Option(""),Option(""))
   implicitInnerJoin.list
 }

}