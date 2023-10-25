package junit.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.payloads.Pets;
import junit.routes.Routes;

import static io.restassured.RestAssured.given;

public class PetEndpoints {

    public static Response createPet(Pets payload) {

        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().
                post(Routes.pet_post_url);

        return response;
    }

    public static Response readPet(int id) {

        Response response = given().
                pathParam("petId", id).
                when().
                get(Routes.pet_get_url);

        return response;
    }

    public static Response updatePet(Pets payload) {

        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().
                put(Routes.pet_update_url);

        return response;
    }

    public static Response deletePet(int id) {

        Response response = given().
                pathParam("petId", id).
                when().
                delete(Routes.pet_delete_url);

        return response;
    }
}