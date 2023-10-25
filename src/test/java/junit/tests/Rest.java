package junit.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;

public class Rest {

    public static void main(String[] args) {
        RestAssured.given().baseUri("https://reqres.in/api/users/2").get().body().as(User.class).data.last_name.compareToIgnoreCase("Weaver");
    }

    @Test
    @Order(1)
    public void sum(int a, int b){

    }

    @Test
    @Order(2)
    public void mul(int a, int b){

    }
}
