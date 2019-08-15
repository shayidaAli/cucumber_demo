package com.cybertek.APItesting;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import org.apache.log4j.Logger;

public class testingAPI {
    Logger log = Logger.getLogger(testingAPI.class);

    //simple get request from api
    @Test
    public void test1() {
        // this is class from rest assured library, it contains methods and objects used for
        // creating and sending requests
        // get --> method for making a get request, accepts the resource uri as parameter
        // response --> it represents the response that came back from server based on out request
        Response response = RestAssured.get("https://uinames.com/api/");//we are sending our get request

        // method 1: prints the response
        response.prettyPrint();//convert it to string and print it


        //Mthod 2:  asString --> converts the response to string
        String resString = response.asString();
        System.out.println(resString);

        //Method 3:
        System.out.println(response.body().asString());


        //verify if the body contains the name
        Assert.assertTrue(resString.contains("name"));

        //print true or false
        System.out.println(resString.contains("name"));

        // statusCode returns the response code
        int code = response.statusCode();
        Assert.assertEquals(200, code);
        System.out.println("status code is : "+ code);


        //print the header
        System.out.println(response.getHeaders().toString());



    }


    //validate response header
    @Test
    public void GetWeatherHeaders()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        //get all the headers:
        System.out.println(response.getHeaders().toString());
        log.info("============printing response headers====================");
        System.out.println("____________________________________________________");


        // Reader header of a give name. In this line we will get
        // Header named Content-Type
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

        // Reader header of a give name. In this line we will get
        // Header named Server
        String serverType =  response.header("Server");
        System.out.println("Server value: " + serverType);

        // Reader header of a give name. In this line we will get
        // Header named Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
        log.info("================printing response headers=======================");
        System.out.println("____________________________________________________");



        //another way of printing the component in header:
        // Get all the headers. Return value is of type Headers.
        // Headers class implements Iterable interface, hence we
        // can apply an advance for loop to go through all Headers
        // as shown in the code below
        Headers allHeaders = response.headers();

        // Iterate over all the Headers
        for(Header header : allHeaders)
        {
            System.out.println("Key: " + header.getName() + " Value:  " + header.getValue());
        }
        log.info("=============printing response headers==================");
    }
}
