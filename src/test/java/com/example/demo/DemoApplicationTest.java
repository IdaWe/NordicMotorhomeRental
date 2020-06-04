package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTest {

    /* @SpringBootTest annotationen "fortæller" spring boot at den skal kigge efter en "Main configuraion class" ("Demo application")
    og tjekke om der er forbindelse til Spring
    */
    @Test
    public void forbindelseTilSpringTest() {
    }

    //hurtig test der viser om Junit virker
    @Test
    public void JunitTest() {
        String str = "Junit virker";
        assertEquals("Junit virker", str);
    }





}