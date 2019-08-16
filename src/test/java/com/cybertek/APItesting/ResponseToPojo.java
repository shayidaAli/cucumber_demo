package com.cybertek.APItesting;

import com.google.gson.Gson;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseToPojo {
    @Test
    public void test1() throws IOException {
        Response response = given().get("https://uinames.com/api/");
//        String name = response.path("name");
//        System.out.println("name = " + name);
        // USING REST ASSURED

        // values from the json response is automatically mapped to correspoonding fields
        // in the person object
        Person p1 = response.as(Person.class);
        System.out.println("p1.getName() = " + p1.getName());//getname method returns the name from thee response
        System.out.println("p1.getSurname() = " + p1.getSurname());
        System.out.println("p1.getGender() = " + p1.getGender());
        System.out.println("p1.getRegion() = " + p1.getRegion());

        // USING GSON conver json into java object
        Gson gson = new Gson();
        Person p2 = gson.fromJson(response.asString(), Person.class);
        System.out.println("p2 = " + p2);


        // USING JACKSON DATABIND
        ObjectMapper objectMapper=  new ObjectMapper();
        Person p3 = objectMapper.readValue(response.asString(), Person.class);
        System.out.println("p3 = " + p3);

    }


    @Test
    public void responseListOfObjects() {
        Response response = given().
                queryParam("amount", "9").
                when().get("https://uinames.com/api/");

        List<Person> people = response.jsonPath().getList("", Person.class);

        for (Person person : people) {
            System.out.println(person);
        }

    }
}
