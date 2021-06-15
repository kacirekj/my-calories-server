package kacirekj.calories.repository;

import kacirekj.calories.domain.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, String> {
    List<Food> findByIdContaining(String id);
}
