package com.communitymap.repository;
import com.communitymap.domain.AppUser;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    java.util.Optional<AppUser> findByEmail(String email);
}
