package com.communitymap.repository;
import com.communitymap.domain.SourceLink;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface SourceLinkRepository extends CrudRepository<SourceLink, Long> {
    java.util.List<SourceLink> findByMapItemId(Long mapItemId);
}
