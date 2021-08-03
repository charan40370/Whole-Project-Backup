package com.in28minutes.rest.webservices.mongo.api.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in28minutes.rest.webservices.mongo.model.ResponseForMockitoTest;
import com.in28minutes.rest.webservices.mongo.model.Todo;
import com.in28minutes.rest.webservices.mongo.repository.TodoRepository;
import com.in28minutes.rest.webservices.mongo.resource.TodoController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoSpringMongodbApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;//  this brings context for our testing, nothing but it creates virtual connection like post man and using that context we can call api service
	//remember the API service Todo service should be active, this context and mockmvc works like post man
	
	// we use MockMvc and webapplication context for creating test cases that tests Rest APIs
    //From MockMvc we get MVC result from which we get the json output, from there we can use object mapper to convert json to object and can validate the status based on that
	
	// you can also check status from MvcResult like status -> String resultContent = result.getResponse().getstatus -> which gives like 200, 400, 401...
	//Like shown in the last test case
	ObjectMapper om = new ObjectMapper();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addEmployeeTest() throws Exception {
		Todo todo = new Todo();
		todo.setId(47);
		todo.setUsername("Basant");
		todo.setDescription("IT");
		todo.setTargetDate(null);
		todo.setDone(false);
		
		
		String jsonRequest = om.writeValueAsString(todo);
		MvcResult result = mockMvc.perform(post("/addTodo").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		ResponseForMockitoTest response = om.readValue(resultContent, ResponseForMockitoTest.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);

	}

	@Test
	public void getEmployeesTest() throws Exception {// this test case fails because we returning set of jsons, but validating  with status which is not there
		MvcResult result = mockMvc
				.perform(get("/findAllTodos").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		//ResponseForMockitoTest response = om.readValue(resultContent, ResponseForMockitoTest.class);
		//Assert.assertTrue(response.isStatus() == Boolean.TRUE);// 
		Assert.assertEquals(result.getResponse().getStatus(), 200);

	}

	
	
	//------------------------------------------------------------------------------------------------------------//
	//Java techie other video with @Autowired and @MockBean
	@Autowired
	TodoController todoController;
	
	@MockBean
	TodoRepository todoRepository;
	
	@Test
	public void getUsersTest() {
		when(todoRepository.findAll()).thenReturn(Stream
				.of(new Todo(376, "Danile","IT", null, false),new Todo(378, "Daddnile","IdT", null, false)).collect(Collectors.toList()));
		assertEquals(2, todoController.getTodos().size());
	}
	
	
	
	
	
	
}
