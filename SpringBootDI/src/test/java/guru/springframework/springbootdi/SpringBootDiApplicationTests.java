package guru.springframework.springbootdi;

import guru.springframework.springbootdi.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootDiApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MyController myController;

	@Test
	void testMyControllerFromAutowired() {
		System.out.println("Inside testMyControllerFromAutowired method : ");
		System.out.println(myController.sayHello());
	}

	@Test
	void testMyControllerFromCtx() {
		MyController controller = applicationContext.getBean(MyController.class);
		System.out.println(controller.sayHello());
	}

	@Test
	void contextLoads() {
	}

}
