package com.perficient.modern.training.platform.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.modern.training.platform.ModernTrainingPlatformApplication;
import com.modern.training.platform.controller.ModernTrainingPlatformController;
import com.modern.training.platform.model.SymbolProfile;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ModernTrainingPlatformApplication.class, ModernTrainingPlatformController.class, SimpleMeterRegistry.class})
@WebMvcTest
public class ModernTrainingPlatformControllerIntegrationTest {
	  
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetCompanyProfile() throws Exception {
		
		String symbol = "TSLA";
		int days = 5;
		
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/company-profile/" + symbol)
	    		.param("days", Integer.toString(days))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
	    
        String json = result.getResponse().getContentAsString();
        assertNotNull(json);
        assertTrue(!json.isEmpty());
        
        // This is arguably not necessary in an integration test
        ObjectMapper mapper = JsonMapper.builder()
	        .addModule(new JavaTimeModule())
	        .build();
        
        SymbolProfile profile = mapper.readValue(json, SymbolProfile.class);
        
        assertEquals(symbol, profile.getSymbol(), "symbol doesn't match");
        assertEquals(days, profile.getQuoteList().size(), "quoteList.size() incorrect");
	}
}
