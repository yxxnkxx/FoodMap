package toy.foodmap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "toy.foodmap.model.dao")
public class FoodmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodmapApplication.class, args);
	}

}
