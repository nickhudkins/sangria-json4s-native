name := "sangria-json4s-native"
organization := "org.sangria-graphql"
version := "1.0.1-SNAPSHOT"

description := "Sangria json4s-native marshalling"
homepage := Some(url("http://sangria-graphql.org"))
licenses := Seq("Apache License, ASL Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.12.8"
crossScalaVersions := Seq("2.11.8", "2.12.8", "2.13.0")

scalacOptions ++= Seq("-deprecation", "-feature")

scalacOptions ++= {
  if (scalaVersion.value startsWith "2.11")
    Seq("-target:jvm-1.7")
  else
    Seq.empty
}

libraryDependencies ++= Seq(
  "org.sangria-graphql" %% "sangria-marshalling-api" % "1.0.4",
  "org.json4s" %% "json4s-native" % "3.5.5",

  "org.sangria-graphql" %% "sangria-marshalling-testkit" % "1.0.2" % "test",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

git.remoteRepo := "git@github.com:sangria-graphql/sangria-json4s-native.git"

// Publishing

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := (_ => false)
publishTo := Some(
  if (version.value.trim.endsWith("SNAPSHOT"))
    "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")

// Site and docs

site.settings
site.includeScaladoc()
ghpages.settings

// nice *magenta* prompt!

shellPrompt in ThisBuild := { state =>
  scala.Console.MAGENTA + Project.extract(state).currentRef.project + "> " + scala.Console.RESET
}

// Additional meta-info

startYear := Some(2016)
organizationHomepage := Some(url("https://github.com/sangria-graphql"))
developers := Developer("OlegIlyenko", "Oleg Ilyenko", "", url("https://github.com/OlegIlyenko")) :: Nil
scmInfo := Some(ScmInfo(
  browseUrl = url("https://github.com/sangria-graphql/sangria-json4s-native.git"),
  connection = "scm:git:git@github.com:sangria-graphql/sangria-json4s-native.git"
))
