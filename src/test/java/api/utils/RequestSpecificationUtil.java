package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationUtil {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.get("base.url"))
                .addHeader("Authorization", "Bearer " + TokenManager.getToken())
                .addHeader("Accept", "application/json")
                .setContentType(ContentType.JSON)
                .build();
    }
}
