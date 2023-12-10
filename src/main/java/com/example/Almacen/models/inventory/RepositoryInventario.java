package com.example.Almacen.models.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInventario extends JpaRepository<Inventario,Long> {

    @Modifying
    @Query(value = "DELETE from inventario where id = :id",nativeQuery = true)
    void deleteInventario(@Param("id") Long id);


}
