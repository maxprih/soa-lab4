package org.bebra.movieejb.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.bebra.soacommons.model.dto.PageDto;
import org.bebra.movieejb.exception.MinimalUsaBoxOfficeMovieNotFound;
import org.bebra.movieejb.exception.MovieNotFoundException;
import org.bebra.movieejb.model.entity.Movie;
import org.bebra.movieejb.model.mapper.MovieMapper;
import org.bebra.movieejb.repository.MovieRepository;
import org.bebra.movieejb.utils.FilterCriterion;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class MovieService implements MovieServiceRemote {
    @Inject
    private MovieRepository movieRepository;
    @Inject
    private MovieMapper mapper;

    @Override
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
        List<FilterCriterion> filters = createFilters(nameValue, nameFilter, idValue, idFilter, taglineValue, taglineFilter, creationDateValue, creationDateFilter, oscarsCountValue, oscarsCountFilter, usaBoxOfficeValue, usaBoxOfficeFilter, coordinatesXValue, coordinatesXFilter, coordinatesYValue, coordinatesYFilter, screenwriterNameValue, screenwriterNameFilter);
        if (genreValue != null && genreFilter != null) {
            filters.add(new FilterCriterion("genre", genreFilter, genreValue));
        }
        return movieRepository.findAll(page, size, sortList, filters);
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Transactional
    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void update(Integer id, Movie newMovie) {
        Movie existingMovie = findById(id);
        Movie updatedMovie = mapper.updateFields(existingMovie, newMovie);
        movieRepository.save(updatedMovie);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
    }

    @Override
    public Movie findMinimalUsaBoxOffice() {
        return movieRepository.findTopByOrderByUsaBoxOfficeAsc().orElseThrow(MinimalUsaBoxOfficeMovieNotFound::new);
    }

    @Override
    public int countByTagline(String tagline) {
        return movieRepository.countAllByTagline(tagline);
    }

    @Override
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
        List<FilterCriterion> filters = createFilters(nameValue, nameFilter, idValue, idFilter, taglineValue, taglineFilter, creationDateValue, creationDateFilter, oscarsCountValue, oscarsCountFilter, usaBoxOfficeValue, usaBoxOfficeFilter, coordinatesXValue, coordinatesXFilter, coordinatesYValue, coordinatesYFilter, screenwriterNameValue, screenwriterNameFilter);
        if (genreValue != null) {
            filters.add(new FilterCriterion("genre", "lt", genreValue));
        }
        return movieRepository.findAll(page, size, sortList, filters);
    }

    private List<FilterCriterion> createFilters(String nameValue, String nameFilter, String idValue, String idFilter, String taglineValue, String taglineFilter, String creationDateValue, String creationDateFilter, String oscarsCountValue, String oscarsCountFilter, String usaBoxOfficeValue, String usaBoxOfficeFilter, String coordinatesXValue, String coordinatesXFilter, String coordinatesYValue, String coordinatesYFilter, String screenwriterNameValue, String screenwriterNameFilter) {
        List<FilterCriterion> filters = new ArrayList<>();

        if (nameValue != null && nameFilter != null) {
            filters.add(new FilterCriterion("name", nameFilter, nameValue));
        }
        if (idValue != null && idFilter != null) {
            filters.add(new FilterCriterion("id", idFilter, idValue));
        }
        if (taglineValue != null && taglineFilter != null) {
            filters.add(new FilterCriterion("tagline", taglineFilter, taglineValue));
        }
        if (coordinatesXValue != null && coordinatesXFilter != null) {
            filters.add(new FilterCriterion("coordinates.x", coordinatesXFilter, coordinatesXValue));
        }
        if (coordinatesYValue != null && coordinatesYFilter != null) {
            filters.add(new FilterCriterion("coordinates.y", coordinatesYFilter, coordinatesYValue));
        }
        if (creationDateValue != null && creationDateFilter != null) {
            filters.add(new FilterCriterion("creationDate", creationDateFilter, creationDateValue));
        }
        if (oscarsCountValue != null && oscarsCountFilter != null) {
            filters.add(new FilterCriterion("oscarsCount", oscarsCountFilter, oscarsCountValue));
        }
        if (usaBoxOfficeValue != null && usaBoxOfficeFilter != null) {
            filters.add(new FilterCriterion("usaBoxOffice", usaBoxOfficeFilter, usaBoxOfficeValue));
        }
        if (screenwriterNameValue != null && screenwriterNameFilter != null) {
            filters.add(new FilterCriterion("screenwriter.name", screenwriterNameFilter, screenwriterNameValue));
        }
        return filters;
    }
}
