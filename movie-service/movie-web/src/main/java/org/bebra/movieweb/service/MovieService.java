package org.bebra.movieweb.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.bebra.movieejb.model.entity.Movie;
import org.bebra.movieejb.service.MovieServiceRemote;
import org.bebra.soacommons.model.dto.PageDto;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;



@ApplicationScoped
public class MovieService {

    private final MovieServiceRemote movieServiceRemote = getFromEJBPool("ejb:/movie-ejb-1.0-SNAPSHOT/MovieService!org.bebra.movieejb.service.MovieServiceRemote");

    public MovieService() throws NamingException {
    }

    public PageDto<Movie> findAll(int page, int size, List<String> sortList,
                                  String nameValue, String nameFilter,
                                  String idValue, String idFilter,
                                  String taglineValue, String taglineFilter,
                                  String creationDateValue, String creationDateFilter,
                                  String oscarsCountValue, String oscarsCountFilter,
                                  String usaBoxOfficeValue, String usaBoxOfficeFilter,
                                  String genreValue, String genreFilter,
                                  String screenwriterNameValue, String screenwriterNameFilter,
                                  String coordinatesXValue, String coordinatesXFilter,
                                  String coordinatesYValue, String coordinatesYFilter) {

        return movieServiceRemote.findAll(page, size, sortList,
                nameValue, nameFilter,
                idValue, idFilter,
                taglineValue, taglineFilter,
                creationDateValue, creationDateFilter,
                oscarsCountValue, oscarsCountFilter,
                usaBoxOfficeValue, usaBoxOfficeFilter,
                genreValue, genreFilter,
                screenwriterNameValue, screenwriterNameFilter,
                coordinatesXValue, coordinatesXFilter,
                coordinatesYValue, coordinatesYFilter);
    }

    public Movie findById(Integer id) {
        return movieServiceRemote.findById(id);
    }

    @Transactional
    public void save(Movie movie) {
        movieServiceRemote.save(movie);
    }

    @Transactional
    public void update(Integer id, Movie newMovie) {
        movieServiceRemote.update(id, newMovie);
    }

    @Transactional
    public void delete(Integer id) {
        movieServiceRemote.delete(id);
    }

    public Movie findMinimalUsaBoxOffice() {
        return movieServiceRemote.findMinimalUsaBoxOffice();
    }

    public int countByTagline(String tagline) {
        return movieServiceRemote.countByTagline(tagline);
    }

    public PageDto<Movie> findAllByGenreLessThan(int page, int size, List<String> sortList,
                                  String nameValue, String nameFilter,
                                  String idValue, String idFilter,
                                  String taglineValue, String taglineFilter,
                                  String creationDateValue, String creationDateFilter,
                                  String oscarsCountValue, String oscarsCountFilter,
                                  String usaBoxOfficeValue, String usaBoxOfficeFilter,
                                  String genreValue,
                                  String screenwriterNameValue, String screenwriterNameFilter,
                                  String coordinatesXValue, String coordinatesXFilter,
                                  String coordinatesYValue, String coordinatesYFilter) {
        return movieServiceRemote.findAllByGenreLessThan(page, size, sortList,
                nameValue, nameFilter,
                idValue, idFilter,
                taglineValue, taglineFilter,
                creationDateValue, creationDateFilter,
                oscarsCountValue, oscarsCountFilter,
                usaBoxOfficeValue, usaBoxOfficeFilter,
                genreValue,
                screenwriterNameValue, screenwriterNameFilter,
                coordinatesXValue, coordinatesXFilter,
                coordinatesYValue, coordinatesYFilter);
    }

    private MovieServiceRemote getFromEJBPool(String name) throws NamingException {
        return (MovieServiceRemote) new InitialContext().lookup(name);
    }
}
