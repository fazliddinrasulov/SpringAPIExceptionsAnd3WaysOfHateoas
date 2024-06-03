package uz.pdp.test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(message = "Length is incorrect", min = 6, max = 12)
    @NotEmpty
    private String name;
}