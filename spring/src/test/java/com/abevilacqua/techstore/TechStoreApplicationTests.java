package com.abevilacqua.techstore;

import com.abevilacqua.techstore.controller.StoreController;
import com.abevilacqua.techstore.repository.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TechStoreApplicationTests {

	private MockMvc mockMvc;

	private StoreController storeController;

	@Autowired
	private ProductRepo productRepo;

	@BeforeEach
	void setup() {
		this.storeController = new StoreController(productRepo);
		this.mockMvc = MockMvcUtils.createMockMvc(storeController);
	}

	@Test
	@DisplayName("Should get list of printers")
	void shouldGetListOfPrinters() throws Exception {
		mockMvc.perform(get("/products")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[*].id").exists())
				.andExpect(jsonPath("$.[*].name").exists())
				.andExpect(jsonPath("$.[*].description").exists())
				.andExpect(jsonPath("$.[*].price").exists());
	}

}
