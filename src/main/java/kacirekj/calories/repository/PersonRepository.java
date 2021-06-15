package kacirekj.calories.repository;

import kacirekj.calories.domain.Activity;
import kacirekj.calories.domain.Food;
import kacirekj.calories.domain.Person;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonRepository extends Repository<Person, String> {
    Person findById(String id);
    List<Activity> findAll();
    Food save(Food marker);
    Person deleteById(String id);
}
