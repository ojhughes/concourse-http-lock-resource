package io.pivotal.spring.cloud.services.resourcelock.service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.sql.DataSource;
import java.io.StringReader;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import io.pivotal.spring.cloud.services.resourcelock.api.PoolController;
import io.pivotal.spring.cloud.services.resourcelock.config.TestDatabaseConfig;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Pools;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.PoolsRecord;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestDatabaseConfig.class, PoolController.class, PoolService.class, JooqAutoConfiguration.class})
@AutoConfigureMockMvc
@Transactional
public class PoolServiceIntegrationTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private PoolService poolService;
	@Autowired
	private DSLContext dbContext;
	@Autowired
	@Qualifier("testPostgres")
	private DataSource testDataSource;

	private JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

	@Test
	public void listPoolsEndpointHasCorrectResponse() throws Exception {

		//Create a pool directly
		String expectedPoolName = "listTestPool";
		dbContext.insertInto(Pools.POOLS).columns(Pools.POOLS.NAME).values(expectedPoolName).execute();

		//MVC request to get list of pools
		ResultActions mvcResult = mvc
				.perform(get("/pool")
						.with(httpBasic("testuser", "testpassword"))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));

		mvcResult.andExpect(MockMvcResultMatchers.status().isOk());

		//Expect list on one pool to be returned
		String responseBody = mvcResult.andReturn().getResponse().getContentAsString();
		JsonArray responseJson = Json.createReader(new StringReader(responseBody)).readArray();
		assertThat(responseJson.getJsonObject(0).getString("name")).isEqualTo(expectedPoolName);
	}


	@Test
	public void createEnpointHasCorrectResponse() throws Exception {
		String expectedPoolName = "testpool1";
		JsonObject requestBody = Json.createObjectBuilder()
									 .add("name", expectedPoolName)
									 .build();
		ResultActions mvcResult = mvc
				.perform(post("/pool")
						.with(httpBasic("testuser", "testpassword"))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody.toString()));
		mvcResult.andExpect(MockMvcResultMatchers.status().isOk());

		String responseBody = mvcResult.andReturn().getResponse().getContentAsString();
		JsonObject responseJson = Json.createReader(new StringReader(responseBody)).readObject();
		assertThat(responseJson.getInt("id")).isGreaterThanOrEqualTo(1);
		assertThat(responseJson.getString("name")).isEqualTo(expectedPoolName);
	}

	@Test
	public void createEnpointCreatesDbEntry() throws Exception {
		String expectedPoolName = "testpool1";
		JsonObject requestBody = Json.createObjectBuilder()
									 .add("name", expectedPoolName)
									 .build();
		ResultActions mvcResult = mvc
				.perform(post("/pool")
						.with(httpBasic("testuser", "testpassword"))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody.toString()));
		mvcResult.andExpect(MockMvcResultMatchers.status().isOk());

		PoolsRecord record = dbContext.selectFrom(Pools.POOLS).where(Pools.POOLS.NAME.eq(expectedPoolName)).fetchOne();
		assertThat(record.getName()).isEqualTo(expectedPoolName);
	}

	@Test
	public void claimLock() {
		String expectedPoolName = "listTestPool";
	}

	@Test
	public void claimLockForEnvironment() {
	}

	@Test
	public void findById() throws Exception {
	}

	@Test
	public void delete() {
	}

	@Test
	public void findByName() {
	}

	@Test
	public void findUnclaimedEnvironments() {
	}

	@Test
	public void releaseEnvironment() {
	}

	@Test
	public void update() {
	}
}