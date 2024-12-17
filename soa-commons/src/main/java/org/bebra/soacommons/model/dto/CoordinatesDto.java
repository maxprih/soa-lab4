package org.bebra.soacommons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesDto implements Serializable {
    private static final long serialVersionUID = 333999L;

    private Long id;
    private long x;
    private double y;
}
