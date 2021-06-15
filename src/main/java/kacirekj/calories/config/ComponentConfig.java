package kacirekj.calories.config;

import kacirekj.calories.component.ApplicationInit;
import kacirekj.calories.component.DataInit;
import kacirekj.calories.repository.FoodEntryRepository;
import kacirekj.calories.repository.FoodRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ComponentConfig {

    @Bean
    public ApplicationInit applicationInit() throws IOException, InterruptedException {
        ApplicationInit applicationInit = new ApplicationInit();
//        applicationInit.init();
        return applicationInit;
    }

    @Bean
    public DataInit dataInit(FoodRepository foodRepository, FoodEntryRepository foodEntryRepository) throws IOException, InterruptedException {
        return new DataInit(foodRepository, foodEntryRepository);
    }
}
