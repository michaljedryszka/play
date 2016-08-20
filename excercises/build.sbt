name := """excercises"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  jdbc,  
  "org.mockito" % "mockito-all" % "1.10.19",
  "com.adrianhurt" %% "play-bootstrap" % "1.0-P25-B3"
)
