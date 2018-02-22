lazy val root = (project in file("."))
  .settings(name := "lagom-play-services-template")
  .aggregate(
    playServiceA
  )
  .settings(commonSettings: _*)

organization in ThisBuild := "com.hitachi.eu"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.4"

val playJsonDerivedCodecs = "org.julienrf" %% "play-json-derived-codecs" % "4.0.0"
val macwire = "com.softwaremill.macwire" %% "macros" % "2.2.5" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val playServiceA = (project in file("play-service-a"))
  .settings(commonSettings: _*)
  .enablePlugins(PlayScala && LagomPlay)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomScaladslServer,
      macwire,
      scalaTest,

      "org.ocpsoft.prettytime" % "prettytime" % "3.2.7.Final",

      "org.webjars" % "foundation" % "6.2.3",
      "org.webjars" % "foundation-icon-fonts" % "d596a3cfb3"
    ),
    EclipseKeys.preTasks := Seq(compile in Compile)
  )


def commonSettings: Seq[Setting[_]] = Seq(
)




