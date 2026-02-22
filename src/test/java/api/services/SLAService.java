package api.services;

import api.models.SLAEvent;
import api.utils.RequestSpecificationUtil;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SLAService {

    private static final String GET_EVENTS_ENDPOINT = "/api/SLAApi/GetEvents";

    public static List<SLAEvent> getEvents(int phase) {

        return given()
                .spec(RequestSpecificationUtil.getRequestSpec())
                .queryParam("phase", phase)
                .when()
                .get(GET_EVENTS_ENDPOINT)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .jsonPath()
                .getList("", SLAEvent.class);
    }

    public static Response getEventsRaw(int phase) {

        return given()
                .spec(RequestSpecificationUtil.getRequestSpec())
                .queryParam("phase", phase)
                .when()
                .get(GET_EVENTS_ENDPOINT);
    }
}
