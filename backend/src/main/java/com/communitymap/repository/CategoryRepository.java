package com.communitymap.repository;
import com.communitymap.domain.Category;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface CategoryRepository extends CrudRepository<Category, Long> {
    java.util.List<Category> findByMapId(Long mapId);
}
