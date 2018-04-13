package org.dwp.euexit.steps;

import org.dwp.euexit.steps.serenity.ChurchillSpeedSteps;
import org.jbehave.core.annotations.Then;
import com.jcabi.aspects.Loggable;

import net.thucydides.core.annotations.Steps;

public class ChurchillSpeedStepDefs {
	
    @Steps
    ChurchillSpeedSteps churchSpeedStep;
    
    @Loggable(Loggable.INFO)
    @Then("I expect the response to be recieved within $seconds")
    public void thenResponseSpeed(Long seconds) {
    	churchSpeedStep.thenResponseSpeed(seconds);
    }


}