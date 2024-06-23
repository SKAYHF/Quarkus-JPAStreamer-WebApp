package org.SourseCamp.app.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Actor.class)
public abstract class Actor$ {

	public static volatile SingularAttribute<Actor, String> firstName;
	public static volatile SingularAttribute<Actor, String> lastName;
	public static volatile SetAttribute<Actor, Film> films;
	public static volatile SingularAttribute<Actor, Short> actorId;
	public static volatile SingularAttribute<Actor, Timestamp> lastUpdate;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String FILMS = "films";
	public static final String ACTOR_ID = "actorId";
	public static final String LAST_UPDATE = "lastUpdate";

}

