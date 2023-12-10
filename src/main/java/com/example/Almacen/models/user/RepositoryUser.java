package com.example.Almacen.models.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<User,Long> {

    Optional<User> findUserByUsername(String username);
    boolean existsByUsername(String username);
    @Modifying
    @Query(value = "DELETE FROM usuario where id = :id", nativeQuery = true)
    void deleteUser(@Param("id") Long id);
}
