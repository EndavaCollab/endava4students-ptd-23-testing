package cucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.models.Category;
import cucumber.models.Pet;
import cucumber.testConfig.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class StepDefinitions {

    private final TestContext testContext;

    public StepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @BeforeAll
    static void execute_before_each_scenario() {
        System.out.println("##########THIS IS EXECUTED BEFORE EACH SCENARIO#########");
    }

    @AfterAll()
    static void execute_after_each_scenario() {

        System.out.println("!!!!!!!!!!!!!!EXECUTED AFTER SCENARIO!!!!!!!!!!!!!!!");
    }

    @Given("the following animals:")
    public void following_animals(List<String> animals) {

        System.out.println(animals);
    }

    @Given("this background step")
    public void backgroundStep() {

        System.out.println("@@@@@This is a background step@@@@@@");
    }

    @Given("print {string} from examples")
    public void printWords(String words) {
        System.out.println(words);
    }


    @Then("request status code is {int}")
    public void verifyStatusCode(Integer statusCode) {
        Response response = (Response) testContext.getScenarioContext().getContext("apiResponse");
        assertThat(response.getStatusCode(), is(statusCode));
    }


    @Given("a new pet is created having id:{int} name:{string}")
    public void newPetCreated(int id, String name) {

        Category categ = new Category(77, "test");
        List<String> photos = new ArrayList<>();
        photos.add("POZA");
        List<Category> listaCateg = new ArrayList<>();
        listaCateg.add(categ);

        Pet pet = new Pet(id, categ, name, photos, listaCateg, "available");

        testContext.getScenarioContext().setContext("validPet", pet);
        testContext.getScenarioContext().setContext("petID", id);
    }

    @When("add new pet API is called")
    public void newPetApiCalled() {

        Pet pet = (Pet) testContext.getScenarioContext().getContext("validPet");

        RequestSpecification requestSpecification;


        requestSpecification = given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .contentType(ContentType.JSON)
                .body(pet);

        Response response = requestSpecification.post();

        testContext.getScenarioContext().setContext("apiResponse", response);
    }

    @When("get pet by id api is called")
    public void getPetById() {
        int petID = (int) testContext.getScenarioContext().getContext("petID");

        RequestSpecification requestSpecification;

        requestSpecification = given()
                .baseUri("https://petstore.swagger.io/v2/pet/" + petID)
                .contentType(ContentType.JSON);

        Response response = requestSpecification.get();

        testContext.getScenarioContext().setContext("apiResponse", response);
    }

    @When("delete pet by id api is called")
    public void deletePetById() {
        int petID = (int) testContext.getScenarioContext().getContext("petID");

        RequestSpecification requestSpecification;

        requestSpecification = given()
                .baseUri("https://petstore.swagger.io/v2/pet/" + petID)
                .contentType(ContentType.JSON);

        Response response = requestSpecification.delete();

        testContext.getScenarioContext().setContext("apiResponse", response);
    }

    @Then("correct pet is retrieved")
    public void correctPetRetrieved() throws JsonProcessingException {
        Response response = (Response) testContext.getScenarioContext().getContext("apiResponse");

        Pet sentPet = (Pet) testContext.getScenarioContext().getContext("validPet");

        ObjectMapper mapper = new ObjectMapper();

        Pet pet = mapper.readValue(response.getBody().asString(), Pet.class);

        System.out.println(pet);
        System.out.println(sentPet);

        Assertions.assertEquals(pet, sentPet);
    }
}
