package com.campuserp.common.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void successFactoryShouldBuildSuccessfulResponseWithData() {
        ApiResponse<String> response = ApiResponse.success("Fetched", "payload");

        assertTrue(response.isSuccess());
        assertEquals("Fetched", response.getMessage());
        assertEquals("payload", response.getData());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void successFactoryWithDefaultMessageShouldUseSuccessText() {
        ApiResponse<Integer> response = ApiResponse.success(42);

        assertTrue(response.isSuccess());
        assertEquals("Success", response.getMessage());
        assertEquals(42, response.getData());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void errorFactoryShouldBuildFailureResponseWithoutData() {
        ApiResponse<Object> response = ApiResponse.error("Validation failed");

        assertFalse(response.isSuccess());
        assertEquals("Validation failed", response.getMessage());
        assertNull(response.getData());
        assertNotNull(response.getTimestamp());
    }
}
