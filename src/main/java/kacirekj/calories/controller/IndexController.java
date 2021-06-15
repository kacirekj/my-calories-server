package kacirekj.calories.controller;

import kacirekj.calories.domain.Food;
import kacirekj.calories.domain.FoodEntry;
import kacirekj.calories.repository.FoodEntryRepository;
import kacirekj.calories.repository.FoodRepository;
import kacirekj.calories.repository.FoodRepositoryCustom;
import kacirekj.calories.util.FoodUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:3000"}, methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})

public class IndexController {

    private FoodRepository foodRepository;
    private FoodRepositoryCustom foodRepositoryCustom;
    private FoodEntryRepository foodEntryRepository;

    public IndexController(FoodRepository foodRepository, FoodRepositoryCustom foodRepositoryCustom, FoodEntryRepository foodEntryRepository) {
        this.foodRepository = foodRepository;
        this.foodRepositoryCustom = foodRepositoryCustom;
        this.foodEntryRepository = foodEntryRepository;
    }

    @GetMapping("food/all")
    public Iterable<Food> getAllMarkers() {
        return foodRepository.findAll();
    }

    @GetMapping("food/{id}")
    public Food getFood(@PathVariable String id) {
        return foodRepository.findById(id).orElse(null);
    }

    @GetMapping("food")
    public List<Food> getFoods(@RequestParam String id) {
        String normalized = FoodUtil.normalizeFoodName(id);
        String[] separated = normalized.split("-");
        return foodRepositoryCustom.findByIdContaining(separated);
    }

    @PostMapping("food")
    public Food postFood(@RequestBody Food marker) {
        return foodRepository.save(marker);
    }

    @DeleteMapping("food/{id}")
    public void deleteFood(@PathVariable String id) {
        foodRepository.deleteById(id);
    }

    @GetMapping("food-entry/all")
    public Iterable<FoodEntry> getAllFoodEntries() {
        return foodEntryRepository.findAll();
    }

    @GetMapping("food-entry/{id}")
    public FoodEntry getAllFoodEntry(@PathVariable Long id) {
        return foodEntryRepository.findById(id).orElse(null);
    }

    @PostMapping("food-entry")
    public Long postFoodEntry(@RequestBody FoodEntry foodEntry) {
        foodEntryRepository.save(foodEntry);
        return foodEntry.getId();
    }

    @DeleteMapping("food-entry/{id}")
    public void deleteFoodEntry(@PathVariable Long id) {
        foodEntryRepository.deleteById(id);
    }
}
