package com.eac.day01;

import com.eac.utility.SpartanTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P03_SpartanTest extends SpartanTestBase {
    /**
     * Send request to Spartan url and save the response
     * Accept application/json
     * GET /spartans
     * Store the response in Response Object that comes from get Request
     * Print out followings
     * - response
     * - Content-Type
     * - Status Code
     * - Get me first spartan gender
     * - Get me first spartan name
     * - Get me all spartan name
     */

    @DisplayName("Testing extending from test base with spartans")
    @Test
    public void getAllSpartans() {

        Response response = get("/spartans");
//        response.prettyPeek();
        System.out.println("response.path(\"id\") = " + response.path("id[0]"));
        System.out.println("Gender = " + response.path("gender[0]"));
        System.out.println("Name = " + response.path("name[0]"));
        System.out.println("phone = " + response.path("phone[0]"));


    }


}
