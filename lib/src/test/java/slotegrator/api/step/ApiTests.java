package slotegrator.api.step;

import slotegrator.api.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;
import io.restassured.response.Response;

// @PropertySource("api_data.properties")
public class ApiTests{

    // private String guest_token;
    // private String user_token;
    // // Unable to get it from specifications. See Readme.
    // private String guest_url;
    //
    // Responses.

        private Response guestTokenResponse;
        private Response newUserResponse;
        private User user;
        private Response profileResponse;

        // get guest token
        @Given("need guest token")
        public void need_guest_token() {
            // Write code here that turns the phrase above into concrete actions
            // Need to check that gurst url in not null
            // send basic authorization requist to guest token
        // get response get token out from response
        // save responce to local variable 
        // TODO: Change for real action
        Response response  = given().auth().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
            .when().get("http://test-api.d6.dev.devcaz.com/");
        int code = response.getStatusCode();
        assertEquals(code, 404);
        this.guestTokenResponse = response;
    }

    @Given("request to register new user")
    public void request_to_register_new_user() {
        /*
        String guestToken = this.guestTokenResponse.path("access_token");
        // create user , read values for prop file or set it here
        User user = new User();
        user.setUsername();
        user.setPassword_change();
        user.setPassword_repeat();
        user.setEmail();
        user.setName();
        user.setSurname();
        this.user = user;

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        Response response = given().contentType("application/json").body(json).post(url);
        int code = response.getStatusCode();
        assertEquals(code, 201);
        this.newUserResponse = response;
        */
        given().auth().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
            .when().get("http://test-api.d6.dev.devcaz.com/").then().statusCode(404);
    }

    @Given("new user has token")
    public void new_user_has_token() {
        /*
        String token = this.newUserResponse.path("");
        Response response = given().auth().basic(this.user.getUsernane, this.user.getPassword())
            .header("","").get(url);
        get what I need.
        */

        given().auth().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
            .when().get("http://test-api.d6.dev.devcaz.com/").then().statusCode(404);
    }

    @When("request user profile")
    public void request_user_profile() {
        /*
        String id = this.user.getID();
        Response response = given().param("id", id).when().get(url);
        int code = response.getStatusCode();
        assertEquals(code, 200);
        this.profileResponse = response;
        */
        given().auth().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
            .when().get("http://test-api.d6.dev.devcaz.com/").then().statusCode(404);
    }

    @Then("must have user profile")
    public void must_have_user_profile() {
        /*
        String username = profileResponse.path("username");
        assertEquals(username, this.user.getUsername());
        */
        given().auth().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
            .when().get("http://test-api.d6.dev.devcaz.com/").then().statusCode(404);
    }


    @Then("request other user profile get response {int}")
    public void get_response(Integer int1) {
        given().auth().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
            .when().get("http://test-api.d6.dev.devcaz.com/").then().statusCode(int1);
    }
}
