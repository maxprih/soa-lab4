package org.bebra.soacommons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto implements Serializable {
    private static final long serialVersionUID = 333777L;

    private Long id;
    private String name;
    private LocalDate birthday;
    private Double height;
    private long weight;
    private String passportId;
}
