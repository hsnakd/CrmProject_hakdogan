package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                 "pretty",            // basically it just prints out additional information about the scenario that is being executed.
                                      // used to print out additional information about the scenario currently executed

                "html:target/cucumber-report.html",             // this generates default cucumber html report
                "rerun:target/rerun.txt",                       // this generates rerun.txt for keep tracking of failed tests
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",  // this plugin generates the "MAVEN CUCUMBER REPORTING"
                "json:target/cucumber.json",                    //
                "junit:target/junit/junit-report.xml",          //
        },
                        /**
                            #pluginS :
                                - inside of the plugin, we determine
                                - the type of the reportS
                                - where do we want to store our reportS
                                - the name of the report file

                        */

        features = "src/test/resources/features",
        // Right click-->Copy Path/Reference-->Path From Content Root
        // feature : where we pass feature files path

        glue = "com/cydeo/step_definitions",
        // Right click-->Copy Path/Reference-->Path From Source Root
        // glue : where we pass step_definitions path

        dryRun = false,
        // if false: If we already implement and everything is already ready in step definitions.
        // executing the step definitions

        // if true: It won't be running our step definitions codes /  not executing the step definitions
        // It will be running the snippets.
        // It will be giving us snippets from feature files that we did not implement yet.
                        /**
                                #dryRun :
                                - to turn and off our step_definition implementations running or not so we can easily generate snippet.

                                - if true: turned on. and will not execute the actual code (java-selenium-junit)
                                - if false: turned off. and will execute the actual code (java-selenium-junit)
                        */

        tags = "@AZLC-1537",
        // or / and / and not ==> "@Regression and not @smoke"

                        /**
                            #tags:
                                - we can create different scenario suites where we can include or exclude different scenarios.

                                - or, and, and not.

                                - or : @a or @b --> scenario will be executed if it has either one of the tags.
                                --> similar to || in java

                                - and : @a and @b --> scenario will be executed if it has BOTH of the tags.
                                --> similar to && in java

                                - and not : @a and @b and not @c
                                - if a scenario has @c tag, it will NOT be executed.
                        */

        publish = true
        /*
        publish = true;
                --> will enable a functionality from cucumber to generate a public link for the report of our final execution of our code
                --> the link will be automatically generated and printed in the console
                --> it will be ready to share with anyone
         */

)
public class CukesRunner {

//      We can run our project using some maven commands from outside our intelliJ using the line below:
//      Gear icon ==> Run Anything...
//          ==> mvn test -Dcucumber.filter.tags=@smoke
//          ==> mvn test -DBROWSER=firefox
//          ==> mvn test -Denvironment="qa" -DBROWSER="chrome" -DclassName=DataTable_StepDefinitions


//      -D - used to specify some parameters
//      cucumber.filter.tags - used to override tags specifications in Test runner class.
//      https://cucumber.io/docs/cucumber/api/?sbsearch=dcucumber&lang=java
}