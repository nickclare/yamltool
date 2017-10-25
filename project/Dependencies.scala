/*
 * Copyright 2017 Nicholas Clare
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt._
import scala.languageFeature.implicitConversions

object Dependencies {

  /* A simple attempt to make declaring lists of dependencies easier */

  type Deps = Seq[ModuleID]

  implicit def depToList(dep: ModuleID): Deps = Seq(dep)

  implicit class DepOps(val deps: Seq[Deps]) extends AnyVal {
    def flatten: Seq[ModuleID] = deps.flatten
  }

  /* Dependencies */

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"

  lazy val scopt = "com.github.scopt" %% "scopt" % "3.7.0"

  object Cats {
    lazy val core = "org.typelevel" %% "cats-core" % "1.0.0-MF"
  }

  object Circe {
    val version = "0.9.0-M1"
    def circeDep(id: String) = "io.circe" %% s"circe-$id" % version

    lazy val core = circeDep("core")
    lazy val generic = circeDep("generic")
    lazy val parser = circeDep("parser")

    lazy val yaml = "io.circe" %% "circe-yaml" % "0.7.0-M1"

    lazy val all = Seq(core, generic, parser, yaml)
  }

}
