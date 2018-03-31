package tech.lander.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerTest {

	@Test
	public void testApp(){
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals( result, "All your base are belong to us.");
	}

}
