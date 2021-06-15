package kacirekj.calories.repository;

import kacirekj.calories.domain.Food;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FoodRepositoryCustomImpl implements FoodRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Food> findByIdContaining(String... ids) {
        String sql = "SELECT * FROM Food WHERE 1=1 ";
        for(String id : ids) {
            sql += "AND id LIKE '%" + id + "%' ";
        }
        return entityManager.createNativeQuery(sql, Food.class).getResultList();
    }
}
