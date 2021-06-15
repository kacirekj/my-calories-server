package kacirekj.calories.domain;

import kacirekj.calories.util.FoodUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private String id;
    private String name;

    private void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        this.id = FoodUtil.normalizeFoodName(name);
    }
}
