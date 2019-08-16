package com.cybertek.APItesting;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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


    //get response body
    @Test
    public void WeatherMessageBody()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        System.out.println("Response Body is: " + body.asString());


        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
    }


// in order to read JSON body from the response:
    @Test
    public void testJSON(){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();//prepare the request

        Response response = httpRequest.get("/Atlanta");
        response.prettyPrint();

        // in order to read JSON body from the response: F irst get the JsonPath object instance from the Response interface
        JsonPath jsonobject = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String city = jsonobject.get("City");

        // Let us print the city variable to see what we got
        System.out.println("City received from Response is : " + city);

        // Print the temperature node
        System.out.println("Temperature received from Response " + jsonobject.get("Temperature"));

        // Print the humidity node
        System.out.println("Humidity received from Response " + jsonobject.get("Humidity"));

        // Print weather description
        System.out.println("Weather description received from Response " + jsonobject.get("Weather"));

        // Print Wind Speed
        System.out.println("City received from Response " + jsonobject.get("WindSpeed"));

        // Print Wind Direction Degree
        System.out.println("City received from Response " + jsonobject.get("WindDirectionDegree"));
    }



//(Path Param) is basically used to identify a specific resource or resources
    @Test
    public void getCityByNameTest(){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather";

        // statement where we prepare the request
        given()
                // adding param 'name' with value 'Qarth'
                .pathParam("name", "Atlanta").
                // send the request
                        when().
                // {name}  --> will be replaces by value of the path param
                        get("/city/{name}").
                prettyPrint();
    }


// Query Parameter is used to sort/filter those response

//city?name=Atlanta # Fetch a city who has name of Atlanta
    @Test
    public void testing3(){
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

        given().queryParam("amount","3").
                queryParam("name","Atlanta").
                when().get().prettyPrint();
    }


    @Test
    public void testAmount(){
        RestAssured.baseURI = "https://uinames.com/api";

        given().
                // provide the key and value of the query param
                        queryParam("amount", "4").
                queryParam("gender","male").
                queryParam("region","mexico").
                when().get().
                prettyPrint();

    }


    //how would you get the weather for one specific city
    @Test
    public void testFairfax(){
        RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather";

//         method 1: add params directly to the url
//         given().get("/Beijing").prettyPrint();

        //method 2: use path param
//        given().pathParam("name","Istanbul").
//                when().
//                get("/city/{name}").
//                prettyPrint();

        //method 3: use query param
//        given().
//                queryParam("name","Ankara").
//                when().
//                get("/city").
//                prettyPrint();
//
        //method4: limit the response with interger
       Response response= given().queryParam("amount","4").when().get();

        assertThat(200, equalTo(response.statusCode()));

    }
//NOTE FOR 8/15

//how to send request:
// 3 method( add params directly to the url, add path param, add query params)


//how to read the response:
//response.getHeaders();  -->print all header info
//response.header("key"); -->return specific header

//response.statusCode(); --> return the status code

// response.prettyprint(); --> print out the response body
// response.getBody().asString();  --> print out the response body
// response.jsonPath(); --> read the json object from the response, specify the json path

//how to specify the amount?   use query param:
//queryParam("amount", "4")


// how to verify response:   use hamcrest to assert.
/*
assertThat(1, equalTo(1));
assertThat("as", is("as"));
assertThat("Shayida", equalToIgnoringCase("shayIDA"));
assertThat(10, lessThan(299));
assertThat(9,greaterThan(10));
assertThat(List, hasSize(5));
 */


//given() --> prepare the request
//params()  --> provide the request specification
//when() --> send the request when the request is already prepared
//get() --> get the response,




}
