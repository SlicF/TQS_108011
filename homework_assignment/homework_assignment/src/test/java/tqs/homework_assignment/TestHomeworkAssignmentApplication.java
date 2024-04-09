package tqs.homework_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
class TestHomeworkAssignmentApplication {

	static void main(String[] args) {
		SpringApplication.from(HomeworkAssignmentApplication::main).with(TestHomeworkAssignmentApplication.class).run(args);
	}

}
