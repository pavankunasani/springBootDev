package springBootapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springBootapp.controller.HelloController;
import com.springBootapp.pojo.Hello;
import com.springBootapp.service.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTester {

	private MockMvc mock;

	@Mock
	private HelloService hs;

	@InjectMocks
	private HelloController hc;

	@Before
	public void setUp() throws Exception {
		mock = MockMvcBuilders.standaloneSetup(hc).build();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHello() {

		try {
			mock.perform(get("/hello")).andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.content().string("hello tester"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testjson() {

		try {
			mock.perform(get("/hello/json/").accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.title", org.hamcrest.Matchers.is("welcome")))
					.andExpect(MockMvcResultMatchers.jsonPath("$.value", org.hamcrest.Matchers.is("user")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testPostJson() {

		String jsonValue = "{\n" + " \"title\": \"hi\",\n" + "" + "	\"value\": \"developer\",\n" + "}";

		Mockito.when(hs.getHelloService()).thenReturn(new Hello("hi", "developer"));

		try {
			mock.perform(MockMvcRequestBuilders.post("/hello/jsonPost").contentType(MediaType.APPLICATION_JSON)
					.content(jsonValue)).andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.title", org.hamcrest.Matchers.is("hi")))
					.andExpect(MockMvcResultMatchers.jsonPath("$.value", org.hamcrest.Matchers.is("developer")))
					.andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Mockito.verify(hs).getHelloService();

	}

}
