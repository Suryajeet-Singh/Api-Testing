//package api.tests;
//
//import api.base.BaseTest;
//import api.models.SLAEvent;
//import api.services.SLAService;
//import api.utils.RequestSpecificationUtil;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.OffsetDateTime;
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//
//public class SecuredApiTest extends BaseTest {
//
//    @Test
//    public void validateGetEventsAPI() {
//
//        List<SLAEvent> events =
//                given()
//                        .spec(RequestSpecificationUtil.getRequestSpec())
//                        .accept("application/json")
//                        .queryParam("phase", 1)
//                        .log().all()
//                        .when()
//                        .get("/api/SLAApi/GetEvents")
//                        .then()
//                        .statusCode(200)
//                        .extract()
//                        .jsonPath()
//                        .getList("", SLAEvent.class);
//
//        Assert.assertFalse(events.isEmpty(), "Response list is empty");
//
//        for (SLAEvent event : events) {
//
//            // Field presence
//            Assert.assertNotNull(event.getHes());
//            Assert.assertNotNull(event.getSlaId());
//            Assert.assertNotNull(event.getMeterId());
//            Assert.assertNotNull(event.getMeterTimeStamp());
//            Assert.assertNotNull(event.getServerTimeStamp());
//
//            // Business rule validation
//            Assert.assertTrue(event.getSlaId() > 0);
//            Assert.assertEquals(event.getHes(), "Crystal");
//
//            // Timestamp format validation
////            OffsetDateTime.parse(event.getMeterTimeStamp());
////            OffsetDateTime.parse(event.getServerTimeStamp());
//        }
//    }
//
//
//
//}


package api.tests;

import api.base.BaseTest;
import api.models.SLAEvent;
import api.services.SLAService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;
import java.util.List;

public class SecuredApiTest extends BaseTest {

    @Test
    public void validateGetEventsAPI() {

        List<SLAEvent> events = SLAService.getEvents(1);

        Assert.assertFalse(events.isEmpty(), "Response list is empty");

        for (SLAEvent event : events) {

            // Field presence
            Assert.assertNotNull(event.getHes(), "HES is null");
            Assert.assertNotNull(event.getSlaId(), "SlaId is null");
            Assert.assertNotNull(event.getMeterId(), "MeterId is null");
            Assert.assertNotNull(event.getMeterTimeStamp(), "MeterTimeStamp is null");
            Assert.assertNotNull(event.getServerTimeStamp(), "ServerTimeStamp is null");

            // Business validation
            Assert.assertTrue(event.getSlaId() > 0, "Invalid slaId");
            Assert.assertEquals(event.getHes(), "Crystal");

            // Timestamp validation
            OffsetDateTime.parse(event.getMeterTimeStamp());
            OffsetDateTime.parse(event.getServerTimeStamp());
        }
    }
}
