package org.dwp.euexit.steps.serenity;

import com.dwp.euexit.PropertyReader;
import com.jcabi.aspects.Loggable;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import java.util.Properties;
import java.sql.*;

public  class CisSteps {

	Response response = null;


    @Step
    @Loggable(Loggable.INFO)
    public void basicCall(String ninoQ, String surnameQ, String dateOfBirthQ, String firstnameQ, String corrIdH) {
       
    	RestAssured.baseURI  =  "https://localhost";
    	//Call the API given the parameters
    	RestAssured.port = Integer.valueOf(443);
    	RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config().getSSLConfig().allowAllHostnames();
/*        response = SerenityRest.given().header("correlationId", corrIdH).param("nino", ninoQ).param("dateOfBirth", dateOfBirthQ).param("lastName", surnameQ)
        		.when().get(RestAssured.baseURI ); */

        response = SerenityRest.given().header("correlationId", "1").param("nino", "200").param("dateOfBirth", "10-Apr-2018").param("lastName", "McTestface")
        		.when().get(RestAssured.baseURI );
    	System.out.println(response.body().toString());
        response.then().statusCode(200);
        
/*    	System.out.println(response.body().toString());
    	System.out.println(response.getStatusCode());
    	System.out.println(response.getStatusLine());
    	System.out.println(response.getHeaders().toString());
    	System.out.println(response.getTime());
    	
    	System.out.println(PropertyReader.getPropVal("serenity.project.name"));
    	System.out.println(response.getTime());
    	
    	
    	response.then().statusCode(200);*/
    	
    	
    	
    	
/*    	//https://localhost?nino=200&dateOfBirth=10-Apr-2018&lastName=McTestface    	
        String baseURI = "https://localhost";
        //response = SerenityRest.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames())).header("correlationId", "1").param("dateOfBirth", "10-Apr-2018").param("lastName", "McTestface")
        //		.when().get(baseURI);
    	RestAssured.port = Integer.valueOf(443);
    	RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config().getSSLConfig().allowAllHostnames();
        response = SerenityRest.given().header("correlationId", "1").param("nino", "200").param("dateOfBirth", "10-Apr-2018").param("lastName", "McTestface")
        		.when().get(baseURI);     
    	System.out.println(response.body().toString());
        response.then().statusCode(200);*/
    	
    	}
    
    
    
    	@Step
    	@Loggable(Loggable.INFO)
    	public void goodResponse() { 
    	
    	response.then().assertThat().statusCode(200);
    	
    	}

    
    	@Step
    	@Loggable(Loggable.INFO)
    	public void bodyExists() {
    	
    	assertNotNull(response.getBody());
    	
    	}
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void givenMatchExists(String ninoQ,String surnameQ, String dateOfBirthQ, String firstnameQ, int corrIdH) {
    		
    		// See http://mongodb.github.io/mongo-java-driver/3.6/driver/getting-started/quick-start/ when more setting up is needed
    		
    		MongoClient mongoClient = new MongoClient("localhost", 27017);
    		MongoDatabase database = mongoClient.getDatabase("test");
    		
    		MongoCollection<Document> Claimants = database.getCollection("Claimants");
    		
    		Document Claimant = Claimants.find(and(eq("nino", ninoQ), eq("surname", surnameQ), eq("corrIdH", corrIdH), eq("dateOfBirth", dateOfBirthQ))).first(); 
    		
    		assertNotNull(Claimant);
    		
    		mongoClient.close();
    	}
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void givenNoMatch(String ninoQ,String surnameQ, String dateOfBirthQ, String firstnameQ, String corrIdH) {
    		
    		// See http://mongodb.github.io/mongo-java-driver/3.6/driver/getting-started/quick-start/ when more setting up is needed
    		
    		MongoClient mongoClient = new MongoClient("localhost", 27017);
    		MongoDatabase database = mongoClient.getDatabase("test");
    		
    		MongoCollection<Document> Claimants = database.getCollection("Claimants");
    		
    		Document Claimant = Claimants.find(and(eq("nino", ninoQ), eq("surname", surnameQ), eq("corrIdH", corrIdH), eq("dateOfBirth", dateOfBirthQ))).first(); 
    		
    		assertNull(Claimant);
    		
    		mongoClient.close();
    	}
    	
    	
  	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void thenBodyStatusFound() {
    		
    		
    		String bodyStatus = response.path("$", "STATUS").toString();
    		
    		String expectStatus = "FOUND";
    		
    		//assertTrue(bodyStatCheck);
    		assertTrue(bodyStatus.contains(expectStatus));
    	}
    	
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void thenBodyStatusNotFound() {
   
    		String bodyStatus = response.path("$", "STATUS").toString();
    		
    		String expectStatus = "FOUND";
    		
    		
    		assertTrue(bodyStatus.contains(expectStatus));
    	}
    	
    	
    	
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void whenWrongEntry(String entryPoint) {
    		
    		response = SerenityRest.given().header("correlationId", 1).relaxedHTTPSValidation().get("https://localhost" + entryPoint);
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void thenErrorCode(int errorCode) {
    		response.then().assertThat().statusCode(errorCode);
    	}
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void whenWrongRequest() {
    		
    		response = SerenityRest.given().header("correlationId", 1).relaxedHTTPSValidation().post("https://localhost");
    		
    	}
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void whenServerError() {
    		
    		response = SerenityRest.given().header("correlationId", 1).relaxedHTTPSValidation().get("https://localhost:443?nino=500&dateOfBirth=50-Err-500&lastName=McErrorman&firstName=Internal");

    	
    	}
    	
    	
    	
/*    	@Step
    	@Loggable(Loggable.INFO)
    	public void thenErrorResponse() {
    		String body = response.body().asString();
    		assertEquals(body, "Internal server error");
    		
    	}*/
    	
    	
    	
    	
    	
    	
    	
    	@Step
    	@Loggable(Loggable.INFO)
    	public void givenMatchExistsPostgreSQL(String ninoQ,String surnameQ, String dateOfBirthQ, String firstnameQ, int corrIdH) {
    		
    		String url = "jdbc:postgresql://localhost:5432/test";
    		
    		Properties props = new Properties();
    		props.setProperty("user","admin");
    		props.setProperty("password","abc");
    		props.setProperty("ssl","false");
    		
    		
    		try {
    		
    		//Create Connection to DB
    		Connection PostDB = DriverManager.getConnection(url, props);
		
    		
    		Statement statement = PostDB.createStatement();
    		ResultSet results = statement.executeQuery("SELECT * FROM Claimants WHERE nino = 'AA 123456A' AND surname = 'Adamson' AND dateOfBirth = '01/01/1900'");

  
				results.last();
			
				
    		int size = results.getRow();
    		
    		assertTrue(size == 2);
    		
    		
    	} catch (SQLException e) {
    		
    		// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    		
    		
    	}
    	
}