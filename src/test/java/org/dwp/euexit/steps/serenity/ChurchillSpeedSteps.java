package org.dwp.euexit.steps.serenity;

import static org.junit.Assert.assertThat;

import org.dwp.euexit.steps.serenity.ChurchillAPISteps;

import com.jcabi.aspects.Loggable;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;



import static org.hamcrest.Matchers.lessThan;


public class ChurchillSpeedSteps {
	
		@Step
	    @Loggable(Loggable.INFO)
	    public void thenResponseSpeed(Long seconds) {
			
			
	//	"Seconds" input to the BDD statements are interpreted as milliseconds by default, *1000 turns them into actual seconds
			Long expectedSeconds = seconds; 
			
			
			
		   Response response = ChurchillAPISteps.response;
		   Long actualRespTime = response.time();
		   
		   Long actualRespTimeSeconds = actualRespTime/1000;
		   
		   assertThat(actualRespTimeSeconds, lessThan(expectedSeconds) );
		   
		   
		   
		   //assertThat(actualRespTime, lessThan(expectedSeconds));
		   System.out.println(actualRespTime);
		   System.out.println(actualRespTime);
		  
	
}
}