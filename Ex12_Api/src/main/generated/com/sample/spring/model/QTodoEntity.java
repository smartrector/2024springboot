package com.sample.spring.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTodoEntity is a Querydsl query type for TodoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTodoEntity extends EntityPathBase<TodoEntity> {

    private static final long serialVersionUID = 1114207064L;

    public static final QTodoEntity todoEntity = new QTodoEntity("todoEntity");

    public final BooleanPath complete = createBoolean("complete");

    public final DatePath<java.time.LocalDate> dueDate = createDate("dueDate", java.time.LocalDate.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> tno = createNumber("tno", Long.class);

    public final StringPath writer = createString("writer");

    public QTodoEntity(String variable) {
        super(TodoEntity.class, forVariable(variable));
    }

    public QTodoEntity(Path<? extends TodoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTodoEntity(PathMetadata metadata) {
        super(TodoEntity.class, metadata);
    }

}

