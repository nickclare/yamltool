import scala.languageFeature.implicitConversions
import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.daikonlogic",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT",
      scalacOptions ++= Seq(
        "-feature"
      )
    )),
    name := "yamltool",
    libraryDependencies ++= Seq[Deps](
      Cats.core,
      Circe.all,
      scopt
    ).flatten,
    // test deps
    libraryDependencies ++= Seq[Deps](
      scalaTest
    ).flatten.map(_ % Test)

  )
