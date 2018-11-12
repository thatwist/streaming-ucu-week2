ThisBuild / version      := "0.1"
ThisBuild / organization := "ua.edu.ucu"
ThisBuild / scalaVersion := "2.12.7"
ThisBuild / scalacOptions += "-Ypartial-unification"
ThisBuild / libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.+" % "test",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
)

lazy val root = (project in file("."))
  .settings(
    name := "streaming-ucu-week2",
    publish / skip := true,
  ).aggregate(main, home_part1, home_part2)

lazy val main = project
  .settings(libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0")

lazy val home_part1 = project
lazy val home_part2 = project.settings(
    libraryDependencies ++= Seq(
      "org.twitter4j" % "twitter4j-core" % "4.0.7",
      "com.h2database" % "h2" % "1.4.197",
      "org.scalikejdbc" %% "scalikejdbc" % "3.3.1",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "com.typesafe.akka" %% "akka-http"   % "10.1.5",
      "com.typesafe.akka" %% "akka-stream" % "2.5.18",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.5"
    )
  )