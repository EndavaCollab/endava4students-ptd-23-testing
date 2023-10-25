package junit.routes;

public class Routes {

    public static String base_url = "https://petstore.swagger.io/v2";

    //Pet
    public static String pet_post_url = base_url + "/pet";
    public static String pet_get_url = base_url + "/pet/{petId}";
    public static String pet_update_url = base_url + "/pet";
    public static String pet_delete_url = base_url + "/pet/{petId}";
}