package com.cybertek.APItesting;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class postRequest {
    //this test wont be executed because no access.
    //SERILIZATION

    @Test
    public void postJson(){
      //prepare the request
        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON. it is from Json dependency
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender");
        requestParams.put("LastName", "Singh");

        requestParams.put("UserName", "simpleuser001");
        requestParams.put("Password", "password1");
        requestParams.put("Email",  "someuser@gmail.com");

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

// Add the Json to the body of the request
        request.body(requestParams.toJSONString());

// Post the request and check the response
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        // Assert.assertEquals(statusCode, "201");
        System.out.println("the status code is : "+ statusCode);

        String successCode= response.jsonPath().get("SuccessCode");
        System.out.println(successCode);

    }



    //for some API, in order to make post call, we need to get access token first
    public static String getTeacherToken() {

        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

        Response response = given().log().all().
                param("email", "teacherva5@gmail.com").
                param("password", "maxpayne").
                get("/sign");
        response.then().log().all().
                assertThat().statusCode(200);

        return response.jsonPath().get("accessToken");

    }


    //post method with query param
    @Test
    public void createTeam1() {

        //GETTING AUTHORIZED BY PROVIDING WHO I AM
        //PROVIDE WHO I AM, THEN GET THE AUTHORIZATION/THE POWER TO ACCESS/TOKEN
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

        Response response = given().log().all().
                param("email", "teacherva5@gmail.com").
                param("password", "maxpayne").
                get("/sign");
        response.then().log().all().
                assertThat().statusCode(200);


        String token =response.jsonPath().get("accessToken");


        System.out.println(token);


        //USE THE TOKEN TO SEND MY REQUEST
        String team ="HAAGSJGAJDS";
        String batch = "8";

        RestAssured.given().
                header("Authorization", token).
                header("Content-Type", "application/json").
                queryParam("campus-location", "VA").
                queryParam("batch-number", batch).
                queryParam("team-name", team).
                when().post("/api/teams/team").
                then().log().all().
                statusCode(201).
                body(is("team "+team+" has been added to the batch "+batch+"."));

    }


    //post method with json object
    @Test
    public void createTeam2(){

        //GETTING AUTHORIZED BY PROVIDING WHO I AM
        //PROVIDE WHO I AM, THEN GET THE AUTHORIZATION/THE POWER TO ACCESS/TOKEN
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

        Response response = given().log().all().
                param("email", "teacherva5@gmail.com").
                param("password", "maxpayne").
                get("/sign");
        response.then().log().all().
                assertThat().statusCode(200);


        String token =response.jsonPath().get("accessToken");

       // RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("campus-location", "VA");
        requestParams.put("batch-number", "11");
        requestParams.put("team-name", "simpleuser001");

        request.
                header("Content-Type", "application/json").
                header("Authorization", token).
                body(requestParams.toJSONString()).
                post("/api/teams/team").then().log().all().statusCode(201);

    }

    @Test
    public void test7(){
        String token= getTeacherToken();

        RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com";
        given().
                header("Authorization", token).get().then().assertThat().statusCode(200);
    }

}

