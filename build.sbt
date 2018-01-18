name := """apiRecetas"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.194"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))


enablePlugins(PlayEbean)
libraryDependencies += evolutions

libraryDependencies += "com.h2database" % "h2" % "1.4.194"

// mysqldatabase
//libraryDependencies += jdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies += ehcache