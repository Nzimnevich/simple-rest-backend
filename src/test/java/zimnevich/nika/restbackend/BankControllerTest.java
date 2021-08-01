package zimnevich.nika.restbackend;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import zimnevich.nika.restbackend.domain.UserInfo;

import static io.restassured.RestAssured.with;

public class BankControllerTest {
//    static {
//        RestAssured.baseURI ="http://localhost:8080/";
//    }


    private RequestSpecification spec = with().baseUri("http://localhost:8080/")
            .basePath("/");

    @Test
    public void bankControllertest() {
        UserInfo[] userInfos = spec.get("user/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);
    }
}
