package org.SourseCamp.app.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.SourseCamp.app.model.Film;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class FilmRepository {

    @PersistenceContext
    EntityManager em;

    private static final int PAGE_SIZE = 20;

    public Optional<Film> getFilm(short filmId) {
        return Optional.ofNullable(em.find(Film.class, filmId));
    }

    public Stream<Film> getFilms(short minLength) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> film = cq.from(Film.class);

        cq.select(film)
          .where(cb.gt(film.get("length"), minLength))
          .orderBy(cb.asc(film.get("length")));

        return em.createQuery(cq).getResultStream();
    }

    public Stream<Film> paged(long page, short minLength) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> film = cq.from(Film.class);

        cq.select(film)
          .where(cb.gt(film.get("length"), minLength))
          .orderBy(cb.asc(film.get("length")));

        return em.createQuery(cq)
                 .setFirstResult((int) (page * PAGE_SIZE))
                 .setMaxResults(PAGE_SIZE)
                 .getResultStream();
    }

    public Stream<Film> actors(String startsWith, short minLength) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> film = cq.from(Film.class);

        Predicate predicate = cb.and(
            cb.like(film.get("title"), startsWith + "%"),
            cb.gt(film.get("length"), minLength)
        );

        cq.select(film)
          .where(predicate)
          .orderBy(cb.desc(film.get("length")));

        return em.createQuery(cq).getResultStream();
    }

    @Transactional
    public void updateRentalRate(short minLength, Float rentalRate) {
        List<Film> films = getFilms(minLength).toList();
        for (Film film : films) {
            film.setRentalRate(rentalRate);
            em.merge(film);
        }
    }
}
