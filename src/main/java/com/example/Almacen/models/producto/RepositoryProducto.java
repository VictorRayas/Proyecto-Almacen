package com.example.Almacen.models.producto;

import com.example.Almacen.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto,Long> {


    Optional<Producto> findProductoByNombre(String producto);


    @Modifying
    @Query(value = "UPDATE producto SET cantidad = :cantidad WHERE id = :id ", nativeQuery = true)
    void updateCantidad(@Param("id") Long id, @Param("cantidad") int nuevaCantidad);

    @Modifying
    @Query(value = "DELETE FROM producto where id =:id", nativeQuery = true)
    void deleteProducto(@Param("id") Long id);


}
