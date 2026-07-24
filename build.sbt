import Dependencies._

ThisBuild / scalaVersion     := "3.3.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
scalacOptions ++= Seq(
  "-no-indent",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-explain", // + actionable error messages
  "-source:3.3", // + pin source level, no silent drift
  // "-Wunused:all",
  "-Wvalue-discard",
  "-Wnonunit-statement",
  "-Wsafe-init",
  "-language:strictEquality", // + catch nonsensical == (Money vs String, etc.)
  "-Xkind-projector",
  "-Xmax-inlines",
  "64"
)

lazy val root = (project in file("."))
  .settings(
    name := "serviceboard",
    libraryDependencies ++= Seq(munit % Test,
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