package org.SourseCamp.app.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Film.class)
public abstract class Film_ {

	public static volatile SingularAttribute<Film, Float> rentalRate;
	public static volatile SingularAttribute<Film, Short> rentalDuration;
	public static volatile SingularAttribute<Film, Short> languageId;
	public static volatile SingularAttribute<Film, Short> length;
	public static volatile SingularAttribute<Film, String> rating;
	public static volatile SingularAttribute<Film, String> description;
	public static volatile SingularAttribute<Film, BigDecimal> replacementCost;
	public static volatile SingularAttribute<Film, String> title;
	public static volatile ListAttribute<Film, Actor> actors;
	public static volatile SingularAttribute<Film, String> specialFeatures;
	public static volatile SingularAttribute<Film, Short> filmId;
	public static volatile SingularAttribute<Film, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Film, Short> originalLanguageId;

	public static final String RENTAL_RATE = "rentalRate";
	public static final String RENTAL_DURATION = "rentalDuration";
	public static final String LANGUAGE_ID = "languageId";
	public static final String LENGTH = "length";
	public static final String RATING = "rating";
	public static final String DESCRIPTION = "description";
	public static final String REPLACEMENT_COST = "replacementCost";
	public static final String TITLE = "title";
	public static final String ACTORS = "actors";
	public static final String SPECIAL_FEATURES = "specialFeatures";
	public static final String FILM_ID = "filmId";
	public static final String LAST_UPDATE = "lastUpdate";
	public static final String ORIGINAL_LANGUAGE_ID = "originalLanguageId";

}

