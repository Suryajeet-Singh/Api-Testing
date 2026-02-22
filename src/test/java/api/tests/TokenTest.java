package api.tests;

import api.base.BaseTest;
import api.utils.TokenManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenTest extends BaseTest {

    @Test
    public void verifyTokenGeneration() {

        String token = TokenManager.getToken();
        Assert.assertNotNull(token);
        System.out.println("Token Generated: " + token);
    }
}
