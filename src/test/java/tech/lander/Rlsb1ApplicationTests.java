package tech.lander;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.lander.controller.HomeController;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Rlsb1Application.class)
public class Rlsb1ApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void testApp(){
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals( result, "All your base are belong to us.");
	}

}
