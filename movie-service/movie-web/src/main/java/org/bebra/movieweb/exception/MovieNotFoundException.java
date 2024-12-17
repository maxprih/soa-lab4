package org.bebra.movieweb.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class MovieNotFoundException extends RuntimeException {
    private final Integer id;
}
