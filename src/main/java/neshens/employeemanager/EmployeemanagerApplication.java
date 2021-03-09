package neshens.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8081");
		// or use
		// System.getProperties().put("server.port", 8081);
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

}
