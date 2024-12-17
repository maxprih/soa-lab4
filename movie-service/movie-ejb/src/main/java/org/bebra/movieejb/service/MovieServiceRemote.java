package org.bebra.movieejb.service;

import jakarta.ejb.Remote;
import jakarta.transaction.Transactional;
import org.bebra.soacommons.model.dto.PageDto;
import org.bebra.movieejb.model.entity.Movie;

import java.util.List;

/**
 * @author max_pri
 */
@Remote
public interface MovieServiceRemote {
    PageDto<Movie> findAll(int page, int size, List<String> sortList,
                           String nameValue, String nameFilter,
                           String idValue, String idFilter,
                           String taglineValue, String taglineFilter,
                           String creationDateValue, String creationDateFilter,
                           String oscarsCountValue, String oscarsCountFilter,
                           String usaBoxOfficeValue, String usaBoxOfficeFilter,
                           String genreValue, String genreFilter,
                           String screenwriterNameValue, String screenwriterNameFilter,
                           String coordinatesXValue, String coordinatesXFilter,
                           String coordinatesYValue, String coordinatesYFilter);

    Movie findById(Integer id);

    @Transactional
    void save(Movie movie);

    @Transactional
    void update(Integer id, Movie newMovie);

    @Transactional
    void delete(Integer id);

    Movie findMinimalUsaBoxOffice();

    int countByTagline(String tagline);

    PageDto<Movie> findAllByGenreLessThan(int page, int size, List<String> sortList,
                                          String nameValue, String nameFilter,
                                          String idValue, String idFilter,
                                          String taglineValue, String taglineFilter,
                                          String creationDateValue, String creationDateFilter,
                                          String oscarsCountValue, String oscarsCountFilter,
                                          String usaBoxOfficeValue, String usaBoxOfficeFilter,
                                          String genreValue,
                                          String screenwriterNameValue, String screenwriterNameFilter,
                                          String coordinatesXValue, String coordinatesXFilter,
                                          String coordinatesYValue, String coordinatesYFilter);
}
