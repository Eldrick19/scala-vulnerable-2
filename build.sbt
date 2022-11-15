lazy val `play-webgoat` = (project in file(".")).enablePlugins(PlayScala)

name := "play-webgoat"
version := "1.0"

crossScalaVersions := Seq("2.13.10", "2.12.17")
scalaVersion := crossScalaVersions.value.head // tc-skip

libraryDependencies ++= Seq(guice, ws)
scalacOptions ++= Seq(
  "-feature", "-unchecked", "-deprecation", "-Xfatal-warnings",
  // "unused" is too fragile w/ Twirl, routes file
  "-Xlint:-unused"
)

  // In your build.sbt add:
  libraryDependencies ++= Seq(
    "com.google.inject"            % "guice"                % "5.1.0",
    "com.google.inject.extensions" % "guice-assistedinject" % "5.1.0"
  )

    // In your build.sbt add:
  libraryDependencies += "net.jodah" % "typetools" % "0.6.3"

    // In your build.sbt add:
  Test / javaOptions ++= Seq(
    "--add-exports=java.base/sun.security.x509=ALL-UNNAMED",
    "--add-opens=java.base/sun.security.ssl=ALL-UNNAMED"
  )
  // Test / fork := true // This is the default anyway, just a reminder in case you changed it to false before