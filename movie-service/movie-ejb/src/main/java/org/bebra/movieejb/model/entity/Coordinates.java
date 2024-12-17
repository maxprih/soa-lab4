package org.bebra.movieejb.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@ToString
@Getter
@Setter
@Entity
@Table(name = "coordinates")
public class Coordinates implements Serializable {
    private static final long serialVersionUID = 333111L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(178)
    private long x;

    @DecimalMax("842.0")
    private double y;
}
