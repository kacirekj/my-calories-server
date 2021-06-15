package kacirekj.calories.config;

import kacirekj.calories.controller.IndexController;
import kacirekj.calories.repository.FoodEntryRepository;
import kacirekj.calories.repository.FoodRepository;
import kacirekj.calories.repository.FoodRepositoryCustom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    
    @Bean
    public IndexController webConsoleController(FoodRepository foodRepository, FoodRepositoryCustom foodRepositoryCustom, FoodEntryRepository foodEntryRepository) {
        return new IndexController(foodRepository, foodRepositoryCustom, foodEntryRepository);
    }
}
