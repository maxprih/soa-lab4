package org.bebra.movieejb.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class MovieNotFoundException extends RuntimeException {
    private final Integer id;
}
