package kacirekj.calories.config;

import kacirekj.calories.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = FoodRepository.class)
public class RepositoryConfig {

    @Autowired
    Environment env;

}
