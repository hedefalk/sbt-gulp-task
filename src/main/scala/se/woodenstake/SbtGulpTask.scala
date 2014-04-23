package se.woodenstake

import sbt._
import Keys._

object SbtGulpTask extends Plugin {
  object GulpKeys {
    val gulp = TaskKey[Unit]("gulp", "run gulp")
  }

  import GulpKeys._

  val gulpSettings = Seq(
    gulp := gulpRunner("default"),
    commands ++= Seq(gulpTaskCommand, gulpDefaultCommand)
  )

  def gulpSettingsIn(c: Configuration): Seq[Setting[_]] = {
    Seq(compile in c <<= (compile in c).dependsOn(gulp in c))
  }

  def gulpDefaultCommand =
    Command.command("gulp") { (state: State) =>
      gulpRunner("default")
      state
    }

  def gulpTaskCommand = {
    Command.single("gulp-task") {
      case (state, task) => {
        gulpRunner(task)
        state
      }
    }
  }

  private def gulpRunner(gulpTask: String) = {
    ("gulp " + gulpTask) !
  }

}







//  (compile in Compile) <<= compile in Compile dependsOn (GulpKeys.gulp in Compile)


