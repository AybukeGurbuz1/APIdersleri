package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01b {

    /*
    Given
       https://reqres.in/api/users/3
    When
       User sends a GET Request to the url
    Then
       HTTP Status Code should be 200
    And
       Content Type should be JSON
    And
       Status Line should be HTTP/1.1 200 OK
    */

    @Test
    public void test01() {

        // Set the URL
        String url = "https://reqres.in/api/users/3";

        // Set the expected data

        // Send the request and get the response
        Response response = given().when().get(url);  // get request yapıyorum geriye bana response verecek (konteynır)
        response.prettyPrint(); // --> bir methodun body si yoksa abstract tır

        // Do Assertion

        // HTTP Status Code should be 200
        // Content Type should be JSON
        // Status Line should be HTTP/1.1 200 OK
        response.
                then(). // then assertion için gerekli
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
    }
}
