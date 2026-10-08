package com.communitymap.places.control;
import com.communitymap.places.entity.MapItem;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface MapItemRepository extends CrudRepository<MapItem, Long> {
    java.util.List<MapItem> findByMapId(Long mapId);
}
