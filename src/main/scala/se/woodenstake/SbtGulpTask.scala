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

object SbtGulpPlugin2 extends Plugin {
  object GulpKeys {
    val gulpDefaultTaskKey = TaskKey[Unit]("gulp", "run gulp with default target")
    val gulpTaskKey = TaskKey[Unit]("run gulp with given target")
  }



  import GulpKeys._

  private def gulpRunner(gulpTask: String) = {
    ("gulp " + gulpTask) !
  }


  val testSettings
  val gulpSettings = Seq(
    newTask <<= str => println(str) }
  )

}

