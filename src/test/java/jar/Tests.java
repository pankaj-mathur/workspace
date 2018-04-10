package jar;

import io.restassured.RestAssured;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class Tests {

	@Test
	public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS() {
		RestAssured.when().get("http://services.groupkt.com/country/get/iso2code/US").then().assertThat().statusCode(200).and().body("RestResponse.result.name",
				is("United States of America"));

	}

}
