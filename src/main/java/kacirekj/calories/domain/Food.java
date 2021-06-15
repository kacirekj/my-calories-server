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
public class Food {

    @Id
    private String id;
    private String name;

    @OneToOne(targetEntity = Category.class, optional = true, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Category category;

    private Integer likes;
    private Integer dislikes;

    private Double calories;

    private Double protein;
    private Double carbs;
    private Double fat;

    private Double fiber;
    private Double salt;

    private Double magnesium;
    private Double vitC;

    @ManyToOne(targetEntity = Person.class, optional = true, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Person author;

    private void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        this.id = FoodUtil.normalizeFoodName(name);
    }

    public void name(String name) {
        this.name = name;
        this.id = FoodUtil.normalizeFoodName(name);
    }

}
