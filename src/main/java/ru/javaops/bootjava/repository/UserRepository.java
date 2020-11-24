package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javaops.bootjava.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}