package ru.javaops.bootjava.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.model.User;

import java.util.Optional;

@Transactional(readOnly = true)
@Tag(name = "User Controller")
public interface UserRepository extends JpaRepository<User, Integer> {

    @RestResource(rel = "by-email", path = "by-email")
    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    @Cacheable("users")
    Optional<User> findByEmailIgnoreCase(String email);

    @RestResource(rel = "by-lastname", path = "by-lastname")
    Page<User> findByLastNameContainingIgnoreCase(String lastName, Pageable page);

    @Override
    @Modifying
    @Transactional
    @CachePut(value = "users", key = "#user.email")
    User save(User user);

    @Override
    @Modifying
    @Transactional
    @CacheEvict(value = "users", key = "#user.email")
    void delete(User user);

    @Override
    @Modifying
    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    void deleteById(Integer integer);
}