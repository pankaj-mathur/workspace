package org.dwp.euexit.steps.serenity;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.jcabi.aspects.Loggable;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import org.jbehave.core.model.ExamplesTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ChurchillAPISteps {

	   private String BASE_DEMOG_END = "http://churchilldemo.itsshared.net/api/datasets/";
	   public static Response response;
	   private String url = null;
	   private String subjectCode = null;
	   private String metCode = null;
	   private String geoTypCode = null;
	   private String monthCode = null;
	   private String yearCode = null;
	     
	   
	   private String subjectCode1 = null;
	   private String metCode1 = null;
	   private String geoTypCode1 = null;
	   private String monthCode1 = null;
	   private String yearCode1 = null;
    
	@Step
    @Loggable(Loggable.INFO)
    public void givenCallToDemographicEndpt(String subject, String metric, String geoType, String year, String month) {
    	
    	//Code Assignment
    	
    		//Subject Code
    	
    	if (subject.equals("UC Claimants")) {
    		subjectCode = "uc";
    	} else if (subject.equals("Active Enterprises")) {
    		subjectCode = "enta";
    	} else if (subject.equals("UC Households")) {
    		subjectCode = "ucbh";
    	} else if (subject.equals("Attendance Allowance Averages")) {
    		subjectCode = "aapa";
    	} else if (subject.equals("Attendance Allowance Entitled")) {
    		subjectCode = "aa";
    	} else if (subject.equals("Attendance Allowance Claimants")) {
    		subjectCode = "aacip";
    	} else if (subject.equals("Carers Allowance Averages")) {
    		subjectCode = "capca";
    	} else if (subject.equals("Carers Allowance Entitled")) {
    		subjectCode = "cae";
    	} else if (subject.equals("Carers Allowance Claimants")) {
    		subjectCode = "capc";
    	} else if (subject.equals("Claimant Count")) {
    		subjectCode = "cc";
    	} else if (subject.equals("Deaths")) {
    		subjectCode = "ucbh";
    	} else if (subject.equals("DLA Averages")) {
    		subjectCode = "dlawaa";
    	} else if (subject.equals("DLA Entitled")) {
    		subjectCode = "ucbh";
    	} else if (subject.equals("DLA Claimants")) {
    		subjectCode = "ucbh";
    		//To be done - other subjects
    	} else if (subject.equals("tba")) {
    		subjectCode = "null";
    	};
    	
    		// Metric Code
    	
    	if (metric.equals("Number")) {
    		metCode = "totals";
    	} else if (metric.equals("Percentage")) {
    		metCode = "percentages";
    			//To be done - other metrics
    	} else if (metric.equals(("tba")) ) {
    		metCode = "null";
    	};
    	
    
    		//geoTyp Code Assignment			
		
		geoTypCode = geoType.toLowerCase();
		
		
			//Year Assignment
		
    	 yearCode = year;	
    		
    		//monthCode Assignment
    	
    		if (month.equals("January")) {
    			monthCode = "1";
    		} else if (month.equals("February" )) {
    			monthCode = "2";
    		} else if (month.equals("March")) {
    			monthCode = "3";
    		} else if (month.equals("April")) {
    			monthCode = "4";
    		} else if (month.equals("May")) {
    			monthCode = "5";
    		} else if (month.equals("June")) {
    			monthCode = "6";
    		} else if (month.equals("July")) {
    			monthCode = "7";
    		} else if (month.equals("August")) {
    			monthCode = "8";
    		} else if (month.equals("September")) {
    			monthCode = "9";
    		} else if (month.equals("October")) {
    			monthCode = "10";
    		} else if (month.equals("November")) {
    			monthCode = "11";
    		} else if (month.equals("December")) {
    			monthCode = "12";
    		} else {
    			monthCode = null;
    		};
    		   	
    				
    	// Build and call URL	
    				
    				
    	url = BASE_DEMOG_END + subjectCode + "/metrics/" + metCode + "/geog-types/" + geoTypCode + "?" + "month=" + monthCode + "&year=" + yearCode;
    	
    	response = SerenityRest.when().get(url);
    	
    	SerenityRest.given();
	};
    
    
    
    @Step
    @Loggable(Loggable.INFO)
    public void whenTheCallIsMade(String outcome) {
    	
    //	assertThat(url,equalTo("http://churchilldemo.itsshared.net/api/datasets/uc/metrics/totals/geog-types/la?month=2&year=2017"));
    	
    	if (outcome == "Successful") {
    		response.then().assertThat().statusCode(200);
    	} else if (outcome == "Unsuccessful") {
    		response.then().assertThat().statusCode(400);}
	};
    
    @Step
    @Loggable(Loggable.INFO)
    public void thenValueForAreaShouldBe(String geoArea, String value) {
    		String pathCode = "find {it.name =='" + geoArea + "'}.total" ;
    		String actualValueString = response.path(pathCode).toString();
    	
    		assertThat(actualValueString,equalTo(value));   
    		
	};
    
    
    @Step
    @Loggable(Loggable.INFO)
    public void thenJSONMatch() {
    	
    	
    	// Convert API Response to String
    	
    	String calledJSONString =  response.body().asString();
    	
    	String pathToJSONsFolder = "./src/test/resources/storedJSONs/";
    		String storedJSONName = subjectCode + "-" + metCode + "-" + geoTypCode + "-" + yearCode + "-" + monthCode + ".JSON" ;
    	
    		//String completeJSONPath = systemProjectPath + pathToJSONsFolder + storedJSONName;
    		String completeJSONPath =  pathToJSONsFolder + storedJSONName;
    	
    	
    	// Import JSON File and convert contents to String
 
		
			Scanner storedJSON = null;
			try {
				storedJSON = new Scanner(new File(completeJSONPath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String storedString  = storedJSON.nextLine();
		
		
		
		// Compare to Called JSON
		
    
    	assertThat(calledJSONString, equalTo(storedString));
    };
    
    
    
    
    @Step
    @Loggable(Loggable.INFO)
    public void thenHeaderShouldContain(String attribute, String value) {
    		String actualHeaderValue = response.getHeader(attribute);
    	
    		assertThat(actualHeaderValue,equalTo(value)); 
    		}

    
    
    
    
    @Step
    @Loggable(Loggable.INFO)
    public void givenCallToDemographicEndptTableValidation(ExamplesTable subjectTable) {
    	List<Map<String, String>> rows = subjectTable.getRows();
    	for (Map<String, String> row : rows) {
    	  String subjectString = row.get("subject");
    	  String metricString = row.get("metric");
    	  String geoTypeString = row.get("geoType");
    	  String yearString = row.get("year");
    	  String monthString = row.get("month");

    	  	if (subjectString.equals("UC Claimants")) {
        		subjectCode1 = "uc";
        	} else if (subjectString.equals("Active Enterprises")) {
        		subjectCode1 = "enta";
        	} else if (subjectString.equals("UC Households")) {
        		subjectCode1 = "ucbh";
        	} else if (subjectString.equals("Attendance Allowance Averages")) {
        		subjectCode1 = "aapa";
        	} else if (subjectString.equals("Attendance Allowance Entitled")) {
        		subjectCode1 = "aa";
        	} else if (subjectString.equals("Attendance Allowance Claimants")) {
        		subjectCode1 = "aacip";
        	} else if (subjectString.equals("Carers Allowance Averages")) {
        		subjectCode1 = "capca";
        	} else if (subjectString.equals("Carers Allowance Entitled")) {
        		subjectCode1 = "cae";
        	} else if (subjectString.equals("Carers Allowance Claimants")) {
        		subjectCode1 = "capc";
        	} else if (subjectString.equals("Claimant Count")) {
        		subjectCode1 = "cc";
        	} else if (subjectString.equals("Deaths")) {
        		subjectCode = "ucbh";
        	} else if (subjectString.equals("DLA Averages")) {
        		subjectCode1 = "dlawaa";
        	} else if (subjectString.equals("DLA Entitled")) {
        		subjectCode1= "ucbh";
        	} else if (subjectString.equals("DLA Claimants")) {
        		subjectCode1 = "ucbh";
        		//To be done - other subjects
        	} else if (subjectString.equals("tba")) {
        		subjectCode1 = "null";
        	};
        	
        	// Metric Code
        	
        	if (metricString.equals("Number")) {
        		metCode1 = "totals";
        	} else if (metricString.equals("Percentage")) {
        		metCode1 = "percentages";
        			//To be done - other metrics
        	} else if (metricString.equals(("tba")) ) {
        		metCode1 = "null";
        	};
        	
        
        		//geoTyp Code Assignment			
    		
    		geoTypCode1 = geoTypeString.toLowerCase();
    		
    		
    			//Year Assignment
    		
        	 yearCode1 = yearString;	
        		
        		//monthCode Assignment
        	
        		if (monthString.equals("January")) {
        			monthCode1 = "1";
        		} else if (monthString.equals("February" )) {
        			monthCode1 = "2";
        		} else if (monthString.equals("March")) {
        			monthCode1 = "3";
        		} else if (monthString.equals("April")) {
        			monthCode1 = "4";
        		} else if (monthString.equals("May")) {
        			monthCode1 = "5";
        		} else if (monthString.equals("June")) {
        			monthCode1 = "6";
        		} else if (monthString.equals("July")) {
        			monthCode1 = "7";
        		} else if (monthString.equals("August")) {
        			monthCode1 = "8";
        		} else if (monthString.equals("September")) {
        			monthCode1 = "9";
        		} else if (monthString.equals("October")) {
        			monthCode1 = "10";
        		} else if (monthString.equals("November")) {
        			monthCode1 = "11";
        		} else if (monthString.equals("December")) {
        			monthCode1 = "12";
        		} else {
        			monthCode1 = null;
        		};
        	
    	  
    	  
    	  url = BASE_DEMOG_END + subjectCode1 + "/metrics/" + metCode1 + "/geog-types/" + geoTypCode1 + "?" + "month=" + monthCode1 + "&year=" + yearCode1;
    		
    	  response = SerenityRest.when().get(url);
      	
      	SerenityRest.given();
    
    
    

    	
}
}
}








