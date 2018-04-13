package org.dwp.euexit.steps;

import org.dwp.euexit.steps.serenity.ChurchillAPISteps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import com.jcabi.aspects.Loggable;

import net.thucydides.core.annotations.Steps;



public class ChurchillAPIStepDefs {
	
    @Steps
    ChurchillAPISteps churchAPIstep;
    
    @Loggable(Loggable.INFO)
    @Given("user call the Churchill Demographic Endpoint with a benefit of $subject, a metric of $metric, a geography type of $geoType, a year of $year, and a month of $month")
    @Alias("user call the Churchill Demographic Endpoint with the parameters below")
    public void givenCallToDemographicEndpt(String subject, String metric, String geoType,String year, String month) {
    	churchAPIstep.givenCallToDemographicEndpt(subject,metric,geoType, year, month);
    }
      	
    
    @Loggable(Loggable.INFO)
    @When("the call is $outcome")
    public void whenTheCallIsMade(String outcome) {
    	churchAPIstep.whenTheCallIsMade(outcome);
    }
    
    @Loggable(Loggable.INFO)
    @Then("user expect the total for $geoArea to be $value")
    public void thenValueForAreaShouldBe(String geoArea, String value) {
    	churchAPIstep.thenValueForAreaShouldBe(geoArea, value);
    }
    
    @Loggable(Loggable.INFO)
    @Then("user expect the called JSON to match the stored JSON file")
    public void thenJSONMatch() {
    	churchAPIstep.thenJSONMatch();

}

    @Loggable(Loggable.INFO)
    @Then("user expect the header attribute $attribute to have a value of $value")
    public void thenHeaderShouldContain(String attribute, String value) {
    	churchAPIstep.thenHeaderShouldContain(attribute, value);
    	
    	
    
}
    
    
    
    @Loggable(Loggable.INFO)
    @Given("I call the Churchill Demographic Endpoint with the parameters below: $subjectTable")
    public void givenCallToDemographicEndptTableValidation(ExamplesTable subjectTable) {
    	churchAPIstep.givenCallToDemographicEndptTableValidation(subjectTable);
    }
}