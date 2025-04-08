package com.eac.day01;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class P01_SimpleGetRequest {
    //http://34.226.136.145:8000/api/spartans
    //http://34.226.136.145:1000/ords/hr/regions
    /**
     * 1. Send request to HR url and save the response
     * 2. GET /regions
     * 3. Store the response in Response Object that comes from GET Request
     * 4. Print out followings
     *     - Headers
     *     - Content-Type
     *     - Status Code
     *     - Response
     *     - Date
     *     - Verify response body has "Europe"
     *     - Verify response has Date
     */
    @Test
    public void simpleTest() {

//                * 1. Send request to HR url and save the response
//                * 2. GET /regions
//                * 3. Store the response in Response Object that comes from GET Request
        Response response = RestAssured.get("http://34.226.136.145:1000/ords/hr/regions");
//        response.prettyPrint(); // returns only the body of the response
//        response.prettyPeek(); // returns header information as well and we can chain methods
//                * 4. Print out followings
//                *     - Headers
        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("==================================================");
        System.out.println("response.headers() = " + response.headers());
//                *     - Content-Type
        System.out.println("==================================================");
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("==================================================");
        System.out.println("response.getContentType() = " + response.getContentType());
//                *     - Status Code
        System.out.println("==================================================");
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("==================================================");
//                *     - Response
        System.out.println("==================================================");
//                *     - Date
        System.out.println("==================================================");
        System.out.println("response.header(\"Date\") = " + response.header("Date"));
        System.out.println("==================================================");
//                *     - Verify response body has "Europe"
        System.out.println("response.asString().contains(\"Europe\") = " + response.asString().contains("Europe"));
        Assertions.assertTrue(response.asString().contains("Europe"));
        System.out.println("==================================================");
//                *     - Verify response has Date
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        System.out.println("==================================================");

        System.out.println("==================================================");

    }

    /**
     * 1. Send request to HR url and save the response
     * 2. GET /employees/100
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     *     - First Name
     *     - Last Name
     *     - Verify status code is 200
     *     - Verify First Name is "Steven"
     *     - Verify content-Type is application/json
     */

    @DisplayName("Response Path Getting the information from one employee 100 using ")
    @Test
    public void getOneEmployeeUsingPath(){
        // * 1. Send request to HR url and save the response
        //     * 2. GET /employees/100
        //     * 3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("http://34.226.136.145:1000/ords/hr/employees/100");
        //     * 4. Print out followings
        //     *     - First Name
        System.out.println("==================================================");
        String firstName = response.path("first_name");
        System.out.println("name = " + firstName);
        //     *     - Last Name
        String lastName = response.path("last_name");
        System.out.println("lastName = " + lastName);
        System.out.println("==================================================");
        //     *     - Verify status code is 200
        assertEquals(200,response.statusCode(),"Status code not 200");
        assertEquals(HttpStatus.SC_OK,response.statusCode(),"Status code not 200");// same as above but using http.status

        System.out.println("==================================================");
        //     *     - Verify First Name is "Steven"

        assertEquals("Steven",firstName);
        System.out.println("==================================================");
        //     *     - Verify content-Type is application/json
        assertEquals("application/json",response.contentType());
        assertEquals(ContentType.JSON.toString(),"application/json");
        System.out.println("response.contentType().equals(\"application/json\") = " + response.contentType().equals("application/json"));
    }
    @DisplayName("Getting the information from one employee 100 using jsonPath")
    @Test
    public void getOneEmployee(){
        // * 1. Send request to HR url and save the response
        //     * 2. GET /employees/100
        //     * 3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("http://34.226.136.145:1000/ords/hr/employees/100");
        JsonPath jsonPath = response.jsonPath(); // parse response to jsonpath
        //     * 4. Print out followings
        //     *     - First Name
        System.out.println("==================================================");
        String name = response.jsonPath().getString("first_name");
        System.out.println("name = " + name);
        //     *     - Last Name
        String lastName = response.jsonPath().getString("last_name");
        System.out.println("lastName = " + lastName);
        System.out.println("==================================================");
        //     *     - Verify status code is 200
        assertEquals(200,response.statusCode(),"Status code not 200");
        System.out.println("==================================================");
        //     *     - Verify First Name is "Steven"

        assertEquals("Steven",name);
        System.out.println("==================================================");
        //     *     - Verify content-Type is application/json
        System.out.println("response.contentType().equals(\"application/json\") = " + response.contentType().equals("application/json"));
    }



}
