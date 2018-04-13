package org.dwp.euexit.steps;

import org.dwp.euexit.steps.serenity.CisSteps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.jcabi.aspects.Loggable;

import net.thucydides.core.annotations.Steps;

public class CisStepDefs {
	
	 @Steps
	    CisSteps CisSteps;
	    
	    @Loggable(Loggable.INFO)
	    @When("user hit the CIS endpoint with a GET request using the parameters, $ninoQ, $surnameQ, $dateOfBirthQ, $firstnameQ, $corrIdH")
	    @Alias("the endpoint is called with the parameters $ninoQ, $surnameQ, $dateOfBirthQ, $firstnameQ, $corrIdH")
	    public void basicCall(String ninoQ, String surnameQ, String dateOfBirthQ, String firstnameQ, String corrIdH) {
	    	CisSteps.basicCall(ninoQ, surnameQ, dateOfBirthQ, firstnameQ, corrIdH);
	    	}
	    
	    
	    @Loggable(Loggable.INFO)
	    @Then("the API responds with a 200 response")
	    public void goodResponse() {
	    	CisSteps.goodResponse();
	    	}
	    
	    @Loggable(Loggable.INFO)
	    @Then("the API responds with a body")
	    public void bodyExists() {
	    	CisSteps.bodyExists();
	    	}
	    
	    @Loggable(Loggable.INFO)
	    @Given("the customer matches, using the parameters $ninoQ, $surnameQ, $dateOfBirthQ, $firstnameQ, $corrIdH")
	    public void givenMatchExists(String ninoQ, String surnameQ, String dateOfBirthQ, String firstnameQ, int corrIdH) {
	    	CisSteps.givenMatchExists(ninoQ, surnameQ, dateOfBirthQ, firstnameQ, corrIdH);

}
	    
	    @Loggable(Loggable.INFO)
	    @Given("the customer doesn't match, using the parameters $ninoQ, $surnameQ, $dateOfBirthQ, $firstnameQ, $corrIdH")
	    public void givenNoMatch(String ninoQ, String surnameQ, String dateOfBirthQ, String firstnameQ, String corrIdH){
	    	CisSteps.givenNoMatch(ninoQ, surnameQ, dateOfBirthQ, firstnameQ, corrIdH);
	    	
	    }
	    
	    
	    @Loggable(Loggable.INFO)
	    @Given("the customer matches PostgreSQL record, using the parameters $ninoQ, $surnameQ, $dateOfBirthQ, $firstnameQ, $corrIdH")
	    public void givenMatchExistsPostgreSQL(String ninoQ, String surnameQ, String dateOfBirthQ, String firstnameQ, int corrIdH) {
	    	CisSteps.givenMatchExistsPostgreSQL(ninoQ, surnameQ, dateOfBirthQ, firstnameQ, corrIdH);
	    	}
	    

	    @Loggable(Loggable.INFO)
	    @Then("the body should contain 'status: FOUND'")
	    public void thenBodyStatusFound() {
	    	CisSteps.thenBodyStatusFound();
	    	}
	    
	    
	    @Loggable(Loggable.INFO)
	    @Then("the body should contain 'status: NOT_FOUND'")
	    public void thenBodyStatusNotFound() {
	    	CisSteps.thenBodyStatusNotFound();
	    	}
	    
	    @Loggable(Loggable.INFO)
	    @When("a customer submits a request for a non-existing entry point, such as $entryPoint")
	    public void whenWrongEntry(String entryPoint) {
	    	CisSteps.whenWrongEntry(entryPoint);
	    	}
	    
	    @Loggable(Loggable.INFO)
	    @Then("return a $errorCode error code")
	    public void thenErrorCode(int errorCode) {
	    	CisSteps.thenErrorCode(errorCode);
	    }
	    
	    @Loggable(Loggable.INFO)
	    @When("a customer submits a request using a HTTP method differing from GET")
	    public void whenWrongRequest() {
	    	CisSteps.whenWrongRequest();
	    	
	    }
	    
	     
	    
	    
}