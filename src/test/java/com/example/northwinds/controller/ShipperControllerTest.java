package com.example.northwinds.controller;

import com.example.northwinds.model.Shipper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"h2", "dbseeder"})
class ShipperControllerTest {
    private static final String SHIPPER_ENDPOINT_URL = "/api/shippers";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
//
//    @Test
//    public void testGETAll() throws Exception {
//        //  Given DB was populated by DBSeeder
//
//        // When: call GET /api
//        String JSON = mockMvc.perform(
//                        get(SHIPPER_ENDPOINT_URL)
//                ).andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//        List<Shipper> shippersFromDB = objectMapper.readValue(JSON, new TypeReference<>() {
//        });
//
//        // Then
//        assertFalse(shippersFromDB.isEmpty());
//        assertEquals(DB_SEEDER_SHIPPERS.size(), shippersFromDB.size());
//    }
//
//    @Test
//    public void testGETById_Success() throws Exception {
//        // Given an existing id
//        int testId = 1;
//
//        // When
//        String JSON = this.mockMvc.perform(get(SHIPPER_ENDPOINT_URL + "/" + testId))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        Shipper shipper = objectMapper.readValue(JSON, Shipper.class);
//
//        // Then
//        assertNotNull(shipper);
//        assertEquals(testId, shipper.getId());
//    }
//
//    @Test
//    public void testGETById_Failure() throws Exception {
//        // Given a non-existing id
//        int testId = 1000;
//
//        // When
//        this.mockMvc.perform(get(SHIPPER_ENDPOINT_URL + "/" + testId))
//                .andDo(print())
//                // Then
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    // After the test, restore database to initial state
//    @DirtiesContext
//    public void testPOST_success() throws Exception {
//        // Given
//        String testName = "John Doe";
//        String testPhone = "082 65723900";
//
//        Shipper testShipper = new Shipper(null, testName, testPhone);
//        String JSONToSent = objectMapper.writeValueAsString(testShipper);
//
//        List<Shipper> before = getAllShippers();
//
//        // When
//        String JSONReceived = this.mockMvc.perform(post(SHIPPER_ENDPOINT_URL)
//                        .header("Content-Type", "application/json")
//                        .content(JSONToSent))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        Shipper shipper = objectMapper.readValue(JSONReceived, Shipper.class);
//
//        // Then
//        List<Shipper> after = getAllShippers();
//        assertEquals(before.size(), after.size() - 1);
//        assertNotNull(shipper);
//        assertEquals(testName, shipper.getName());
//        assertEquals(testPhone, shipper.getPhone());
//    }
//
//    @Test
//    // After the test, restore database to initial state
//    @DirtiesContext
//    void testPOST_failure() throws Exception {
//        // Given
//        String testName = "";
//        String testPhone = "082 65723900";
//
//        Shipper testShipper = new Shipper(null, testName, testPhone);
//        String JSONToSent = objectMapper.writeValueAsString(testShipper);
//
//
//        // When
//        this.mockMvc.perform(post(SHIPPER_ENDPOINT_URL)
//                        .header("Content-Type", "application/json")
//                        .content(JSONToSent))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @DirtiesContext
//    public void testPUT_success() throws Exception {
//        //  Given DB was populated by DBSeeder
//
//        long existingId = 1;
//        String newName = "New name for shipper 1";
//        String newPhone = "095 443422 9987";
//
//        Shipper shipperToUpdate = new Shipper(null, newName, newPhone);
//        String JSONToSend = objectMapper.writeValueAsString(shipperToUpdate);
//
//        List<Shipper> before = getAllShippers();
//
//        // When
//        String JSONFromResponse = this.mockMvc.perform(put(SHIPPER_ENDPOINT_URL + "/" + existingId)
//                        .header("Content-Type", "application/json")
//                        .content(JSONToSend))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        // Then
//        List<Shipper> after = getAllShippers();
//        Shipper shipper1FromDBAfterUpdate = objectMapper.readValue(JSONFromResponse, Shipper.class);
//        assertEquals(newName, shipper1FromDBAfterUpdate.getName());
//        assertEquals(newPhone, shipper1FromDBAfterUpdate.getPhone());
//        assertEquals(before.size(), after.size());
//    }
//
//    @Test
//    public void testPUT_failure_nonExitingId() throws Exception {
//        //  Given DB was populated by DBSeeder
//
//        long nonExistingId = 1000;
//        String newName = "New name for shipper 1";
//        String newPhone = "095 443422 9987";
//
//        Shipper shipperToUpdate = new Shipper(null, newName, newPhone);
//        String JSONToSend = objectMapper.writeValueAsString(shipperToUpdate);
//
//        // When
//        this.mockMvc.perform(put(SHIPPER_ENDPOINT_URL + "/" + nonExistingId)
//                        .header("Content-Type", "application/json")
//                        .content(JSONToSend))
//                .andDo(print())
//                // Then
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @DirtiesContext
//    public void testDELETE_Success() throws Exception {
//        //  Given DB was populated by DBSeeder
//        long existingID = 1;
//
//        // When
//        this.mockMvc.perform(delete(SHIPPER_ENDPOINT_URL + "/" + existingID))
//                .andDo(print())
//                // Then
//                .andExpect(status().isOk());
//
//    }
//    @Test
//    public void testDELETE_Failure() throws Exception {
//        //  Given DB was populated by DBSeeder
//        long nonExistingID = 1000;
//
//        // When
//        this.mockMvc.perform(delete(SHIPPER_ENDPOINT_URL + "/" + nonExistingID))
//                .andDo(print())
//                // Then
//                .andExpect(status().isNotFound());
//    }
//
//
//    private List<Shipper> getAllShippers() throws Exception {
//        String JSON = mockMvc.perform(get(SHIPPER_ENDPOINT_URL))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//        return objectMapper.readValue(JSON, new TypeReference<>() {
//        });
//    }

}