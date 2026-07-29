import Dependencies._

ThisBuild / scalaVersion := "3.3.8"
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalacOptions := Seq(
  "-encoding",
  "UTF-8",
  "-no-indent",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-source:3.3",
  "-java-output-version:17",
  "-Werror",
  "-Wvalue-discard",
  "-Wnonunit-statement",
  "-Xlint:all",
  "-Ysafe-init",
  "-Xcheck-macros",
  "-Xmax-inlines:64"
)

ThisBuild / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = (project in file("."))
  .settings(
    name := "serviceboard",
    libraryDependencies ++= Seq(
      munit % Test,
      guice,
      "jakarta.inject" % "jakarta.inject-api" % "2.0.1",
      "com.outr" %% "scribe" % "3.19.0",
      "com.outr" %% "scribe-slf4j" % "3.19.0"
    )
  )
  .enablePlugins(PlayJava)

addCommandAlias("fmt", "scalafmtAll; scalafmtSbt")
addCommandAlias("fmtCheck", "scalafmtCheckAll; scalafmtSbtCheck")

Test / parallelExecution := true

ThisBuild / outputStrategy := Some(StdoutOutput)
