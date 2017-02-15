http://griffon-framework.org/index.html
http://griffon-framework.org/tutorials/3_mvcgroups_javafx.html


Install

$ curl -s http://get.sdkman.io | bash
$ sdk install lazybones
$ sdk install gradle



Next register the griffon-lazybones-templates repository with Lazybones' config file. Edit $USER_HOME/.lazybones/config.groovy

bintrayRepositories = [
    "griffon/griffon-lazybones-templates",
    "pledbrook/lazybones-templates"
]


Starting the project

$ lazybones create griffon-javafx-java sample-javax-java



Compile, run and test the project with any of these commands

$ gradle build
$ gradle test
$ gradle run


You may use Maven as an alternate build tool

$ mvn compile
$ mvn test
$ mvn -Prun





Afterburner.gfx project template
--------------------------------

You've just created a basic [Afterburner.gfx][afterburner.gfx] application. It provides the
standard project structure and simple configurations for [Gradle][gradle] to build and run 
the project.

The project's structure is laid out as follows

    <proj>
      |
      +- src
          |
          +- main
              |
              +- groovy
              |
                 // application sources
              |
              +- resources
              |
                 // FXML, CSS and GroovyFX

To compile and run the application with Gradle

    gradlew run

[gradle]: http://www.gradle.org
[javafx-gradle]: https://bitbucket.org/shemnon/javafx-gradle
[afterburner.fx]: http://afterburner.adam-bien.com
[afterburner.gfx]: https://bitbucket.org/bgoetzmann/afterburner.gfx/wiki/Home
