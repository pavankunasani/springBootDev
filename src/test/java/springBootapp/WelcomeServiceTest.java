package springBootapp;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import com.springBootapp.component.WelcomeComponent;
import com.springBootapp.pojo.Greeting;
import com.springBootapp.pojo.UserGreet;
import com.springBootapp.service.WelcomeService;

@RunWith(MockitoJUnitRunner.class)
public class WelcomeServiceTest {

	@Mock
	private WelcomeComponent wc;

	@InjectMocks
	private WelcomeService ws;
	
	

	@Test
	public void greetMssgService() {

		when(wc.getUserData()).thenReturn(new UserGreet("HTC"));

		Greeting greet = ws.getGreetMssg();

		System.out.println(greet.toString());
	}
	
	/*@Test
	public void cAddress(){
		
		try {
			mockMvc.perform(get("/customer")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.name").value("Jack")).andExpect(jsonPath("$.location").value("US"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}*/

}
