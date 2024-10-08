# EclipseCon demo projects for JDT with Javac

This repository hosts the source project and the scenario description to demo JDT with JavacY

## Scenario

### Prerequisites

Projects need to be available on filesystem
* eclipsecon-demo-jdt-with-javac
* spring-petclinic
* spring-data-jpa
* java-jwt

with `mvn verify && mvn clean` already run on those.

### Demo things working

#### Basics

Open `spring-petclinic` in editor/IDE, show features working
* outline view
* control-click navigation
* code completion
* create an edit that causes an error
  * show diagnostic
* show quickfix

Show generated .class files (maybe highlight they're from Javac)

#### Annotation processing

* Demo a mapstruct annotation processing sample in `annotation_processing` package
* Highlight the generated .java files (highlight they're from Javac)
* Modify a source file and showcase the generated .java file is updated

#### Build
* Full Build
  * Open the `target/classes/build` folder to show the .class files
* Incremental Build
  * Open `build/Dto.java` and add a new field `String role`
  * Open the `target/classes/build` folder to show the updated .class files (Compare the timestamp to see only the affected classes are updated)

#### Tests and debugging

* Open BasicTest.java
* Put a breakpoint in `assert...`
* Debug as JUnit Test
* see breakpoints, step into `areWeIn2024`, value of `year` on hover... working

### Differences with ECJ

* Type inference ( https://github.com/eclipse-jdt/eclipse.jdt.core/issues/494 ): Use TypeInferenceDemo.java
* dots in folder name ( https://github.com/redhat-developer/vscode-java/issues/1406 ): Use DotInFolderNames.java
* Annotation processing (AbortCompilation): https://github.com/spring-projects/spring-data-jpa.git - throw AbortCompilation when handling annotation processing
* JPMS: try importing https://github.com/auth0/java-jwt ; ECJ fails, Javac ?

### Showcase introduction a new Java feature

#### Better recovery/diagnostics in Java 24

* Open javac24isBetter/Test.javac
  * With ECJ: uninteresting messages
  * with Javac (23): crash ☹️, messy diagnostics
  * with Javac 24: no crash but empty -> check log -> add problem mapping -> re-edit => much better!

#### A new feature

Find a small Java 24 feature already supported by Javac and that we have easily-ish converted to JDT. Then for the presentation, revert this support. Show the feature is missing and reimplement live the support to showcase it's a matter of minutes.
