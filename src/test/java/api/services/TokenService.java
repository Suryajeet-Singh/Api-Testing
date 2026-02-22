package api.services;

import api.utils.ConfigManager;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//package api.services;
//
//import api.utils.ConfigManager;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//
//public class TokenService {
//
//    public static String generateToken() {
//
//        Response response =
//                given()
//                        .baseUri(ConfigManager.get("base.url"))
//                        .contentType(ContentType.JSON)
//                        .body(Map.of(
//                                "project_id", Integer.parseInt(ConfigManager.get("project.id")),
//                                "user", ConfigManager.get("username"),
//                                "password", ConfigManager.get("password")
//                        ))
//                        .when()
//                        .post("/token")
//                        .then()
//                        .statusCode(200)
//                        .extract().response();
//
//        return response.jsonPath().getString("access_token");
//    }
//}
public class TokenService {

    public static String generateToken() {

        Response response =
                given()
                        .baseUri(ConfigManager.get("base.url"))
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("grant_type", ConfigManager.get("grant_type"))
                        .formParam("username", ConfigManager.get("username"))
                        .formParam("password", ConfigManager.get("password"))
                        .formParam("client_id", ConfigManager.get("client_id"))
//                        .formParam("client_secret", ConfigManager.get("client.secret"))
                        .log().all()
                        .when()
                        .post("/token")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .response();

        return response.jsonPath().getString("access_token");
    }
}
