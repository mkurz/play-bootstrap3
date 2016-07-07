name := """play-bootstrap"""

version := "1.1-P25-B4-SNAPSHOT"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8")

resolvers ++= Seq(
  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  filters,
  "com.adrianhurt" %% "play-bootstrap-core" % "1.1-P25-SNAPSHOT",
  "org.webjars" % "bootstrap" % "4.0.0-alpha" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "2.2.4",
  specs2 % Test
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)



scalariformSettings

//*******************************
// Maven settings
//*******************************

sonatypeSettings

publishMavenStyle := true

organization := "com.adrianhurt"

description := "This is a collection of input helpers and field constructors for Play Framework to render Bootstrap HTML code."

homepage := Some(url("https://adrianhurt.github.io/play-bootstrap"))

licenses := Seq("Apache License" -> url("https://github.com/adrianhurt/play-bootstrap/blob/master/LICENSE"))

startYear := Some(2014)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:adrianhurt/play-bootstrap.git</url>
    <connection>scm:git:git@github.com:adrianhurt/play-bootstrap.git</connection>
  </scm>
  <developers>
    <developer>
      <id>adrianhurt</id>
      <name>Adrian Hurtado</name>
      <url>https://github.com/adrianhurt</url>
    </developer>
  </developers>
)

credentials += Credentials(Path.userHome / ".sbt" / "sonatype.credentials")
