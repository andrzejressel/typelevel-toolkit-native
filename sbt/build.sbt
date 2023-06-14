scalaVersion := "3.3.0"

enablePlugins(ScalaNativePlugin)

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

// defaults set with common options shown
nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
}

libraryDependencies ++= Seq(
  "org.typelevel" %%% "toolkit" % "0.1.1"
)

// libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.0"