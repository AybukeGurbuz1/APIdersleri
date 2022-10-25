import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman, manual API testleri için kullandık
    2) Otomasyon testleri için de Rest Assured Library kullanacağız
    3) Otomasyon testlerimizi yaparken aşağıdaki adımları izliyoruz;
         a) Gereksinimleri anlamak,
         b) Test Case yazıyoruz
             i) Test Case yazımında "Gherkin" dilini kullanacağız.Bizler yazılım diline hakim olsak da karşımızdaki kişiler hakim olmayabilir
             ama Gherkin ile yazılan testleri anlamakta zorluk çekmeyeceklerdir
             Gherkin dilinde kullanacağımız keywordler;

             - Given : ön koşullar
             - When : yapılacak aksiyonlar için (get(), post(), patch() ve delete() )
             - Then : istek yaptıktan (request gönderdikten sonra) doğrulama
             - And : çoklu işlemlerde kullanacağız

          c) Test Kodlarımızı Yazmaya Başlayacağız

             i)  Set the URL
             ii) Set the expected Data (beklenen datanın oluşturulması, Post, Put, Patch)
             iii) Type code to send request ( Talep göndermek için kod yazımı)
             iv) Do Assertion (doğrulama yapmak)
     */

    /*
    Given
        https://restful-booker.herokuapp.com/booking/101
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
    public void get01() {
        // i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/101";

        // ii) Set the expected Data (beklenen datanın oluşturulması, Post, Put, Patch)
        // Bizden post, put yada patch istenmediği için bu case de kullanmayacağız

        // iii) Type code to send request ( Talep göndermek için kod yazımı)
        Response response = given().when().get(url);
        response.prettyPrint();

        // iv) Do Assertion (doğrulama yapmak)

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdıralım
        System.out.println("Status Code: " + response.getStatusCode());

        // Content Type konsola yazdıralım
        System.out.println("Content Type: " + response.getContentType());

        // Status Line konsola yazdıralım
        System.out.println("Status Line: " + response.getStatusLine());

        // Header konsola yazdıralım
        System.out.println("Header: " + response.getHeader("Server"));

        // Headers konsola yazdıralım
        System.out.println("Headers: " + response.getHeaders());

        // time konsola yazdıralım
        System.out.println("Time: " + response.getTime());



    }
}
