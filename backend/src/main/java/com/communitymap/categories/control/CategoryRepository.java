package com.communitymap.categories.control;
import com.communitymap.categories.entity.Category;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface CategoryRepository extends CrudRepository<Category, Long> {
    java.util.List<Category> findByMapId(Long mapId);
}
