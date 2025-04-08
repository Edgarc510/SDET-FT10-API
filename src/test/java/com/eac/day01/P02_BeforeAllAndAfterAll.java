package com.eac.day01;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P02_BeforeAllAndAfterAll {

    //We can create testBase in utilities to initialize before all and after all and not include it
    //in every class we create
    @BeforeAll
    public static void init(){
        baseURI="http://34.226.136.145:1000";
        basePath="/ords/hr";
    }

    @AfterAll
    public static void destroy(){

        reset();
    }


    @DisplayName("BeforeAll And After methods review")
    @Test
    public void test01(){
        Response response = get("regions");
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

}
