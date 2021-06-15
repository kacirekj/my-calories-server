package kacirekj.calories.repository;

import kacirekj.calories.domain.FoodEntry;
import org.springframework.data.repository.CrudRepository;

public interface FoodEntryRepository extends CrudRepository<FoodEntry, Long> {
}
