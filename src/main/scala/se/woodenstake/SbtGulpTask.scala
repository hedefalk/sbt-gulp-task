package se.woodenstake

import sbt._
import Keys._

object SbtGulpTask extends Plugin {
  lazy val gulpTaskSettings = commands ++= Seq(gulpTaskCommand, gulpDefaultCommand)
  
  private def gulpRunner(gulpTask: String) = {
    ("gulp " + gulpTask) !
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
}


