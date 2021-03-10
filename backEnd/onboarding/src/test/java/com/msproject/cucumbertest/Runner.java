package com.msproject.cucumbertest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="feature/onboardee.feature", glue= {"stepdefination"} )
public class Runner {

}
