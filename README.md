sbt-gulp-task
============
Simply stolen from https://github.com/parkotron/sbt-grunt-task

####plugins.sbt
	addSbtPlugin("se.woodenstake" %% "sbt-gulp-task" % "0.1")

####build.sbt
	import se.woodenstake.SbtGulpTask

	…

	SbtGulpTask.gulpTaskSettings

####Working with the plugin
Your package.json and gulpfile.js should be in the root of your project:
	
	gulp

will run the default gulp task

	gulp-task <taskname>

will run the specified task by name

####Useful other SBT commands 

	watchSources <++= baseDirectory map { path => ((path / "src" / "main" / "webapp" / "app" ) ** "*.js").get }
Will allow the task to run on every file change (in this case just js files) in the specified folder when you run gulp with

	~ gulp

or

	~ gulp-task <taskname>