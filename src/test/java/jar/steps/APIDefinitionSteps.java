package jar.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.jcabi.aspects.Loggable;

import jar.steps.serenity.APISteps;
import net.thucydides.core.annotations.Steps;

public class APIDefinitionSteps {
	
    @Steps
    APISteps apiSteps;
    
    @Loggable(Loggable.INFO)
    @Given("the user try to call API to find country using country code $countryCode")
    public void givenTheUserTryToCallAPIToFindCountryUsingCountryCode(String countryCode) {
    	apiSteps.givenTheUserTryToCallAPIToFindCountryUsingCountryCode(countryCode);
    }
    
    @Loggable(Loggable.INFO)
    @When("the user search is executed successfully")
    public void whenTheUserSearchIsExecutedSuccessfully() {
    	apiSteps.whenTheUserSearchIsExecutedSuccessfully();
    }
    
    @Loggable(Loggable.INFO)
    @Then("user should find country $countryName")
    public void thenUserShouldFindCountry(String countryName) {
    	apiSteps.thenUserShouldFindCountry(countryName);
    }

}
