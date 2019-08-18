package com.cybertek.APItesting;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class getAccessToken {
//Authorization

    @Test
    public void getTokenTest() {

        //write base url, prepare your request
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com/";

        //create response object, using valid user credentials
        Response response = given().log().all().
                param("email", "teacherva5@gmail.com").
                param("password", "maxpayne").
                get("/sign"); //now you have the response after log in to room reservation app

                response.then().log().all().
                assertThat().statusCode(200);



 //  response contains the access token, Now use jsonPath object to parse through json response easily
       String accessToken = response.jsonPath().get("accessToken");

        System.out.println(accessToken);

        // trying to get the my campus
        // we are passing our token as a part of the request header


        RestAssured.given().
                  header("Authorization", accessToken).
                get("/api/campuses").then().log().all().
                assertThat().statusCode(200);

    }

}

//if you dont have the access, you will get 422 error/connection closed

//in order to get access token:
//add valid log in credentials as parameters, then get the response
//get the access token from reponse json object

