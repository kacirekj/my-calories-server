package kacirekj.calories.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_entry_generator")
    @SequenceGenerator(name="author_generator", sequenceName = "food_entry_seq", allocationSize = 1000)
    private Long id;

    @OneToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    private Person author;

    @OneToOne(targetEntity = Food.class, fetch = FetchType.EAGER)
    private Food food;

    private LocalDate date;

    private DaytimeEnum kind;

    private Integer amount;
}
