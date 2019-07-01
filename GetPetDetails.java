package GetPetId;
//Get Pet Details using rest assured- Configured in Eclipse- Sriganesh
//Import Libraries for the test
import org.junit.Assert;
import org.junit.Test;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//Get Pet Details
public class GetPetDetails {
	
	@DataProvider
	public static Object[][] PetIdsTestData() {
	         
	    return new Object[][] {
	            {"One", "2345"},
	            {"Two", "5678"},
	            {"Three", "6789"}
	    };
	}
	
	@Test
	@UseDataProvider("PetIdsTestData")
	public void TestValidPetId(String TestCaseNo, String PetId)
	{
		System.out.println("TestCase"+TestCaseNo+"With PetId:"+PetId);
		Response resp= RestAssured.get("https://petstore.swagger.io/pet/(PetId)");
		int code= resp.getStatusCode();
		Assert.assertEquals(code,200);
	}

}
