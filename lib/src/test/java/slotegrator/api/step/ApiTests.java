// package slotegrator.api;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.When;
// import io.cucumber.java.en.Then;
// import java.util.Properties;
// import slotegrator.PropertiesUtil;
// 
// 
// public class ApiTests{
// 
//         private String guest_token;
//         private String user_token;
//         private Properties props;
// 
// 
//     private Properties getProps() {
//         if (this.props != null) {return this.props;}
// 
//         Properties p = PropertiesUtil.loadProperties(this.getClass(), "/api/data.properties");
//         assert p != null : "properties are null in ApiTest:getProps.";
//         this.props = p;
//         return p;
//     }
//         // get guest token
//     @Given("need guest token")
//     public void need_guest_token() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
//     @When("request guest token")
//     public void request_guest_token() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
// 
// 
//     // register new user
//     @Given("have guest token")
//     public void have_guest_token() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
//     @When("request to register")
//     public void request_to_register() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
// 
// 
//     // get new user's profile
//     @Given("have user token")
//     public void have_user_token() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
//     @When("request user profile")
//     public void request_user_profile() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
//     @Then("must have user profile")
//     public void must_have_user_profile() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
//     @When("request other user profile")
//     public void request_other_user_profile() {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
//     @Then("get response {int}")
//     public void get_response(Integer int1) {
//         // Write code here that turns the phrase above into concrete actions
//         throw new io.cucumber.java.PendingException();
//     }
// 
// }
