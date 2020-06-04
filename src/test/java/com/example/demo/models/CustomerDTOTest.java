package com.example.demo.models;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerDTOTest {

    //test at vores getter + setter i CustomerDTO klassen virker
    @Test
    public void DTOgetterSetter() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCusFirstName("ole");
        assertEquals("ole", customerDTO.getCusFirstName());
    }

    //tester om to-string metoden indeholder de forskellige attributter
    @Test
    void toStringTest() {
        CustomerDTO customerDTO = new CustomerDTO();
        String toString = customerDTO.toString();

        assertTrue(toString.contains("cusFirstName="));
        assertTrue(toString.contains("cusLastName="));
        assertTrue(toString.contains("cusPhone="));
        assertTrue(toString.contains("cusAddress="));
        assertTrue(toString.contains("cusZip="));
        assertTrue(toString.contains("cusCity="));
        assertTrue(toString.contains("cusDriversLicense="));
        assertTrue(toString.contains("cusEmail="));


    }

}