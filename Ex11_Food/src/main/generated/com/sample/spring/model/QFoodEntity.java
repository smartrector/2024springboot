package com.sample.spring.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFoodEntity is a Querydsl query type for FoodEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodEntity extends EntityPathBase<FoodEntity> {

    private static final long serialVersionUID = 388867440L;

    public static final QFoodEntity foodEntity = new QFoodEntity("foodEntity");

    public final StringPath address = createString("address");

    public final DateTimePath<java.time.ZonedDateTime> createdAt = createDateTime("createdAt", java.time.ZonedDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.ZonedDateTime> updatedAt = createDateTime("updatedAt", java.time.ZonedDateTime.class);

    public QFoodEntity(String variable) {
        super(FoodEntity.class, forVariable(variable));
    }

    public QFoodEntity(Path<? extends FoodEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodEntity(PathMetadata metadata) {
        super(FoodEntity.class, metadata);
    }

}

