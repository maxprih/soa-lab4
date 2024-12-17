package org.bebra.movieejb.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;


@ToString
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 333001L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private LocalDate birthday;

    @NotNull
    @DecimalMin("0.0")
    private Double height;

    @Min(0)
    private long weight;

    @Column(name = "passport_id", unique = true, length = 20)
    private String passportId;
}
