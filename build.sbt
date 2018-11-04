ThisBuild / version      := "0.1"
ThisBuild / organization := "ua.edu.ucu"
ThisBuild / scalaVersion := "2.12.7"
ThisBuild / scalacOptions += "-Ypartial-unification"
ThisBuild / libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.+" % "test",
  "org.typelevel" %% "cats-core" % "1.4.0"
)

lazy val root = (project in file("."))
  .settings(
    name := "streaming-ucu-week2",
    publish / skip := true,

  ).aggregate(main, home_part1, home_part2)

lazy val main = project
lazy val home_part1 = project
lazy val home_part2 = project