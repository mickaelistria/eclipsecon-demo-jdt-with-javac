# EclipseCon demo projects for JDT with Javac

This repository hosts the source project and the scenario description to demo JDT with JavacY

## Scenario

### Demo things working

#### Basics

Open `spring-petclinic` in editor/IDE, show features working
* outline view
* control-click navigation
* code completion
* create an edit that causes an error
  ** show diagnostic
* show quickfix

Show generated .class files (maybe highlight they're from Javac)

#### Annotation processing

#### Tests and debugging

* Open BasicTest.java
* Put a breakpoint in `assert...`
* Debug as JUnit Test
* see breakpoints, step into `areWeIn2024`, value of `year` on hover... working

### Differences with ECJ

* Type inference ( https://github.com/eclipse-jdt/eclipse.jdt.core/issues/494 ): Use TypeInferenceDemo.java
* 