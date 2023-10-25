package junit.tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import junit.endpoints.PetEndpoints;
import junit.payloads.Pets;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest {

    static Faker faker;
    static Pets petPayload;

    @BeforeAll
    public static void setup() {
        faker = new Faker();
        petPayload = new Pets();

        petPayload.setId(faker.idNumber().hashCode());
        petPayload.setName(faker.name().name());
    }

    @Test
    @Order(1)
    public void testPostPet() {

        Response response = PetEndpoints.createPet(petPayload);
        response.then().log().all();

        Assertions.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    @Order(2)
    public void testGetPet() {

        Response response = PetEndpoints.readPet(petPayload.getId());
        response.then().log().all();

        Assertions.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    @Order(3)
    public void testDeletePet() {

        Response response = PetEndpoints.deletePet(petPayload.getId());
        response.then().log().all();

        Assertions.assertEquals(response.getStatusCode(), 200);
    }
}