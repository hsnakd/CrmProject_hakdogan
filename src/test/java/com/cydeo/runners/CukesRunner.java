package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)            //  This annotation tells JUnit to run this class using the Cucumber class.
@CucumberOptions(                   // This annotation provides the configuration for your Cucumber tests.

        // Specifies the different output formats and storage locations for test reports using plugins (pretty, html, rerun, etc.)
        plugin = {

                // Prints additional information about the scenario being executed
                "pretty",
                // Generates rerun.txt to track failed tests
                "rerun:target/rerun.txt",
                // Generates default HTML cucumber report
                "html:target/cucumber-report.html",
                // Generates the "Maven Cucumber Reporting" using PrettyReports plugin
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                // Generates the "MAVEN CUCUMBER REPORTING" using PrettyReports plugin
                "json:target/cucumber.json",
                // Generates JUnit XML format report
                "junit:target/junit/junit-report.xml",

        },

        // Defines the location of your feature files
        features = "src/test/resources/features",     // Right click-->Copy Path/Reference-->Path From Content Root

        // Specifies the package where your step definitions are located.
        glue = "com/miaplaza/step_definitions",       // Right click-->Copy Path/Reference-->Path From Source Root

        // When set to false, executes the actual tests; if true, checks step definitions without executing tests
        dryRun = false,

                // if false: If we already implement and everything is already ready in step definitions.
                // executing the step definitions

                // if true : It won't be running our step definitions codes /  not executing the step definitions,
                // It will be running the snippets.
                // It will be giving us snippets from feature files that we did not implement yet.

        // Allows you to run a specific subset of scenarios based on tags
        tags = "@miaplaza",                 // or / and / and not ==> "@Regression and not @smoke"


        // Indicates whether to publish the results and generate a public link for sharing
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