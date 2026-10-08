package com.communitymap.organizations.control;
import com.communitymap.organizations.entity.Organization;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    java.util.Optional<Organization> findByName(String name);
}
