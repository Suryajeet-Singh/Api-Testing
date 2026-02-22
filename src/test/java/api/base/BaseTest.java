package api.base;

//import api.utils.RequestSpecBuilderUtil;
import api.utils.RequestSpecificationUtil;
import api.utils.TokenManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        TokenManager.getToken();
    }
}
