package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


    @SpringBootTest()
    class HomeControllerTest {
        /*
        Her tester vi om der er forbindelse til vores HomeController. Vi gør det med "assertThat", som er en assert mekanisme(?) (assertThat([value], [matcher statement]),
        som tager en værdi og et statement - i dette tilfælde tjekker den om forbindelsen til vores homeController er null eller ej.
       */
        @Autowired
        private HomeController controller;

        @Test
        public void doesHomeControllerLoad() throws Exception {
            assertThat(controller).isNotNull();
        }
    }


