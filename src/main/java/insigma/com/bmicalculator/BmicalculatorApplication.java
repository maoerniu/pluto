package insigma.com.bmicalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BmicalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmicalculatorApplication.class, args);
	}

}