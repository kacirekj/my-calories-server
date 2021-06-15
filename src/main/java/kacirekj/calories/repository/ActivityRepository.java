package kacirekj.calories.repository;

import kacirekj.calories.domain.Activity;
import kacirekj.calories.domain.Food;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ActivityRepository extends Repository<Activity, String> {
    Food findById(String id);
    List<Activity> findAll();
    Food save(Food marker);
    Activity deleteById(String id);
}
