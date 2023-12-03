package guru.springframework.springbootdi;

import guru.springframework.springbootdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringBootDiApplication.class, args);
		MyController controller = ctx.getBean(MyController.class);

		System.out.println("Inside Main method");

		System.out.println(controller.sayHello());
	}

}
