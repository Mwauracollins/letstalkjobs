package org.simplifyinternships.letstalkjobs.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AuthenticationService authenticationService;

    @Test
    public void registerTest() throws Exception {
        // Prepare mock response
        RegisterResponse mockResponse = new RegisterResponse("mockAccessToken", "mockRefreshToken");
        when(authenticationService.register(any(RegisterRequest.class))).thenReturn(mockResponse);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                        .content(asJsonString(new RegisterRequest("email", "password", "firstName", "lastName", UserRole.APPLICANT, "12233434")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accessToken").value("mockAccessToken"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.refreshToken").value("mockRefreshToken"));
    }

    @Test
    public void authenticateTest() throws Exception {
        // Prepare mock response
        AuthenticationResponse mockResponse = new AuthenticationResponse("mockAccessToken", "mockRefreshToken");
        when(authenticationService.authenticate(any(AuthenticationRequest.class))).thenReturn(mockResponse);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .content(asJsonString(new AuthenticationRequest("email", "password")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/home"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accessToken").value("mockAccessToken"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.refreshToken").value("mockRefreshToken"))
                .andExpect(MockMvcResultMatchers.cookie().exists("access_token"))
                .andExpect(MockMvcResultMatchers.cookie().exists("refresh_token"));
    }

    // Utility method to convert object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
