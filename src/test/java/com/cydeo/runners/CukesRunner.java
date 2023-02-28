package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        publish = true,
        plugin = {
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt"
        },
        dryRun = false,
        tags = ""
)

public class CukesRunner {
}
