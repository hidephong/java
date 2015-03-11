import play.Project._

name := "QuizMan"

version := "1.0"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.0.2",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.postgresql" % "postgresql" % "9.3-1101-jdbc41",
  jdbc,
  anorm,
  cache
)

playScalaSettings