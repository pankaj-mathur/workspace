package org.dwp.euexit.steps.serenity;

import static org.hamcrest.Matchers.is;

import com.jcabi.aspects.Loggable;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class APISteps extends ScenarioSteps {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1667824118196839648L;
	private String ISO_CODE_SEARCH = "http://services.groupkt.com/country/get/iso2code/";
	   private Response response;
	   private String ccode = null;
    
    @Step
    @Loggable(Loggable.INFO)
	public void givenTheUserTryToCallAPIToFindCountryUsingCountryCode(String countryCode) {
    	ccode = ISO_CODE_SEARCH + countryCode;
    	SerenityRest.given();
	}
    
    @Step
    @Loggable(Loggable.INFO)
	public void whenTheUserSearchIsExecutedSuccessfully() {
    	response = SerenityRest.when().get(ccode);
	}
    
    @Step
    @Loggable(Loggable.INFO)
	public void thenUserShouldFindCountry(String countryName) {
    	
    	response.then().assertThat().statusCode(200);
    	
    	response.then().statusCode(200).and()
    				   .body("RestResponse.result.name", is(countryName));
	}
}