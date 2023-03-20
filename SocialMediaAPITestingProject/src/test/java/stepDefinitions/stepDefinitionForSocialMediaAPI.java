package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinitionForSocialMediaAPI {
	
	RequestSpecification requestSpecification;
	Response response; 
	
	@Given("a user is logged in")
	public void a_user_is_logged_in() {
		RestAssured.baseURI	= "https://jsonplaceholder.typicode.com";
		requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
	}
	
	@When("the user creates a new post with desired text")
	public void the_user_creates_a_new_post_with_desired_text() {
		requestSpecification = given().spec(requestSpecification).body("[\r\n"
				+ "  {\r\n"
				+ "    \"userId\": 101,\r\n"
				+ "    \"id\": 101,\r\n"
				+ "    \"title\": \"Social Media post title\",\r\n"
				+ "    \"body\": \"Social Media message body\"\r\n"
				+ "  }\r\n"
				+ "]");
		 response = requestSpecification.when().post("posts").then().extract().response();
	}
	
	@Then("the post should be created successfully")
	public void validationAfterSubmittingPostOrComment() {
		assertEquals(201,response.getStatusCode());	
	}
	
	@When("the user comments on a post")
	public void the_user_comments_on_a_post() {
		requestSpecification = given().spec(requestSpecification).body("[\r\n"
				+ "  {\r\n"
				+ "    \"postId\": 100,\r\n"
				+ "    \"id\": 101,\r\n"
				+ "    \"name\": \"Test User Name\",\r\n"
				+ "    \"email\": \"testEmail@gmail.com\",\r\n"
				+ "    \"body\": \"Testing comment on a post\"\r\n"
				+ "  }\r\n"
				+ "]");
		 response = requestSpecification.when().post("comments").then().extract().response();
	}
	
	@Then("the comment should be submitted successfully")
	public void the_comment_should_be_submitted_successfully() {
		validationAfterSubmittingPostOrComment();
	}
	
	@When("the user sends a request to view the list of all users")
	public void the_user_sends_a_request_to_view_the_list_of_users() {
		requestSpecification = given().spec(requestSpecification);
		response = requestSpecification.when().get("users").then().log().all().extract().response();
	}
	
	@Then("the list of all users should be retuned successfully")
	public void validationOfResult() {
		assertEquals(200,response.getStatusCode());
	}

	@When("the user searches based on {string} {string}")
	public void the_user_searches_based_on(String criteria, String value) {
		requestSpecification = given().spec(requestSpecification).queryParam(criteria, value);;
		response = requestSpecification.when().get("users").then().log().all().extract().response();
	}
	
	@Then("the user details should be fetched and displayed for the customer")
	public void the_user_details_should_be_fetched_and_displayed_for_the_customer() {
		validationOfResult();
	} 
	
	@When("the user tries to retrieve posts based on {string} {string}")
	public void the_user_tries_to_retrieve_posts_based_on(String criteria, String value) {
		requestSpecification = given().spec(requestSpecification).queryParam(criteria,value);
		response = requestSpecification.when().get("posts").then().log().all().extract().response();
	}
	
	@Then("the posts should be retrieved")
	public void the_posts_should_be_retrieved() {
		validationOfResult();
	}
	
	@When("the user tries to retrieve comments on a post based on {string} {string}")
	public void the_user_tries_to_retrieve_comments_on_a_post_based_on(String criteria, String value) {
		requestSpecification = given().spec(requestSpecification).queryParam(criteria,value);
		response = requestSpecification.when().get("comments").then().log().all().extract().response();
	}
	
	@Then("the comments should be retrieved")
	public void the_comments_should_be_retrieved() {
		validationOfResult();
	}
	
	@When("the user sends a request to view all the posts")
	public void the_user_sends_a_request_to_view_all_the_posts() {
		requestSpecification = given().spec(requestSpecification);
		response = requestSpecification.when().get("posts").then().log().all().extract().response();
	}
	
	@Then("all the posts should be fetched successfully")
	public void all_the_posts_should_be_fetched_successfully() {
		validationOfResult();
	}
	
	@When("the user sends a request to view all the comments")
	public void the_user_sends_a_request_to_view_all_the_comments() {
		requestSpecification = given().spec(requestSpecification);
		response = requestSpecification.when().get("comments").then().log().all().extract().response();
	}
	
	@Then("all the comments should be fetched successfully")
	public void all_the_comments_should_be_fetched_successfully() {
		validationOfResult();
	}
	
	@When("the user sends a request to delete a post")
	public void the_user_sends_a_request_to_delete_a_post() {
		requestSpecification = given().spec(requestSpecification);
		response = requestSpecification.when().delete("posts/{id}", 1).then().log().all().extract().response();
	}
	
	@Then("the post should be deleted successfully")
	public void the_post_should_be_deleted_successfully() {
		validationOfResult();
	}
	
	@When("the user sends a request to delete a comment")
	public void the_user_sends_a_request_to_delete_a_comment() {
		requestSpecification = given().spec(requestSpecification);
		response = requestSpecification.when().delete("comments/{id}", 1).then().log().all().extract().response();
	}
	
	@Then("the comment should be deleted successfully")
	public void the_comment_should_be_deleted_successfully() {
		validationOfResult();
	}
	
	@When("the user edits the post")
	public void the_user_edits_the_post() {
		requestSpecification = given().spec(requestSpecification).body("[\r\n"
				+ "  {\r\n"
				+ "    \"userId\": 10,\r\n"
				+ "    \"id\": 100,\r\n"
				+ "    \"title\": \"Social Media post title\",\r\n"
				+ "    \"body\": \"Social Media message body updated\"\r\n"
				+ "  }\r\n"
				+ "]");
		 response = requestSpecification.when().put("posts/100").then().extract().response();
	}
	
	@Then("the post should be updated successfully")
	public void the_post_should_be_updated_successfully() {
		validationOfResult();
	}
	
	@When("the user edits the comment")
	public void the_user_edits_the_comment() {
		requestSpecification = given().spec(requestSpecification).body("[\r\n"
				+ "  {\r\n"
				+ "    \"postId\": 100,\r\n"
				+ "    \"id\": 500,\r\n"
				+ "    \"name\": \"Test User Name\",\r\n"
				+ "    \"email\": \"testEmail@gmail.com\",\r\n"
				+ "    \"body\": \"Updating the comment on a post\"\r\n"
				+ "  }\r\n"
				+ "]");
		 response = requestSpecification.when().put("comments/500").then().extract().response();
	}
	
	@Then("the comment should be updated successfully")
	public void the_comment_should_be_updated_successfully() {
		validationOfResult();
	}
	
	@When("the user edits the post using patch method")
	public void the_user_edits_the_post_using_patch_method() {
		requestSpecification = given().spec(requestSpecification).body("[\r\n"
				+ "  {\r\n"
				+ "    \"title\": \"Social Media post title updated\"\r\n"
				+ "  }\r\n"
				+ "]");
		 response = requestSpecification.when().patch("posts/10").then().extract().response();
	}
	
	@When("the user edits the comment using patch method")
	public void the_user_edits_the_comment_using_patch_method() {
		requestSpecification = given().spec(requestSpecification).body("[\r\n"
				+ "  {\r\n"
				+ "    \"body\": \"Updating the comment on a post through patch method\"\r\n"
				+ "  }\r\n"
				+ "]");
		 response = requestSpecification.when().put("comments/500").then().extract().response();
	}
	
}
