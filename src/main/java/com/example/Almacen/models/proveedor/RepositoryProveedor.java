package com.example.Almacen.models.proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProveedor extends JpaRepository<Proveedor, Long> {
    @Modifying
    @Query(value = "DELETE FROM proveedor where id=:id",nativeQuery = true)
    void deleteProveedor(@Param("id") Long id);


}
