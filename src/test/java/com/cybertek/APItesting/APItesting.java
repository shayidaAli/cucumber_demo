package com.cybertek.APItesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


public class APItesting {
 /*
 POSITIVE Test:
Fisrt, get access Token with valid username and password, check the status
Then, (Serilization) post using JSONobject, check if it is working.

NEGATIVE Test:
Try to get access token with invalid username and password.
  */

    @Test
    public void post(){
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

        Response response= given().param("email", "teacherva5@gmail.com").
                param("password", "maxpayne").
                get("/sign");

        response.then().assertThat().statusCode(200);

        String token = response.jsonPath().get("accessToken");
        System.out.println(token);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("campus-location", "VA");
//        jsonObject.put("batch-number","1111");
//        jsonObject.put("team-name","mmm");

        RestAssured.given().header("Authorization", token).get("/api/campuses").prettyPrint();
//
//
//        RestAssured.given().
//                header("Authorization", token).
//                header("Content-Type", "application/json").
//                queryParam("campus-location", "VA").
//                queryParam("batch-number", "2").
//                queryParam("team-name", "nerds").
//                when().post("/api/teams/team").then().statusCode(201);

        RestAssured.given().
                header("Authorization", token).
                header("Content-Type", "application/json").
                queryParam("campus-location", "VA").
                queryParam("batch-number", "7").
                queryParam("team-name", "dasdada").
                when().post("/api/teams/team").
                then().log().all().
                statusCode(201).
                body(is("team "+"dasdada"+" has been added to the batch "+"7" + "."));


    }


    /*
    TASK 3:
user uni/names API
1. get a person's information, use JsonPath Object to to do deserilization, create a String list for the person.+
2. get 3 persons information, use for loop to print each of them separately
3. create a POJO class(you can use mine), use GSON to print a persons information.

     */
    @Test
    public void test1(){
        RestAssured.baseURI ="https://uinames.com/api/";

        Response response=given().get();
        response.prettyPrint();
/*
{
    "name": "Valentin",
    "surname": "Caraciobanu",
    "gender": "male",
    "region": "Romania"
}
 */
        JsonPath jsonPath= response.jsonPath(); //everything comes from the response body
        String name= jsonPath.get("name");
        String surname= jsonPath.get("surname");
        String gender= jsonPath.get("gender");
        String rregion= jsonPath.get("region");

        List<String> p1 = new ArrayList<>();
        p1.add(name);
        p1.add(surname);
        p1.add(gender);
        p1.add(rregion);

        System.out.println(p1.toString());

    }

    @Test
    public void test2(){
        RestAssured.baseURI ="https://uinames.com/api/";

        Response response = given().queryParam("amount","3").queryParam("region","Turkey").get();
        response.prettyPrint();

        List <Person> threePeople =response.jsonPath().getList("",Person.class);

        for (Person p : threePeople){
//            System.out.println(p);
            System.out.println( "this person is a " + p.getGender()  + ",  the name is  "+ p.getName());

        }

    }


}
