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

import static com.abevilacqua.techstore.TestUtils.createProduct;
import static com.abevilacqua.techstore.TestUtils.mapToJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
		this.mockMvc = TestUtils.createMockMvc(storeController);
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

	@Test
	@DisplayName("Should find a product by ID")
	void shouldFindAProductByID() throws Exception {
		mockMvc.perform(get("/products/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.description").exists())
				.andExpect(jsonPath("$.price").exists());
	}

	@Test
	@DisplayName("Should create a product")
	void shouldCreateAProduct() throws Exception {
		mockMvc.perform(post("/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapToJson(createProduct())))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.description").exists())
				.andExpect(jsonPath("$.price").exists());
	}

	@Test
	@DisplayName("Should update product")
	void shouldUpdateProduct() throws Exception {
		mockMvc.perform(put("/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapToJson(createProduct())))
				.andExpect(status().isOk());
	}

	@Test
	@DisplayName("Should delete product")
	void shouldDeleteProduct() throws Exception {
		shouldCreateAProduct();
		mockMvc.perform(delete("/products/6")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
