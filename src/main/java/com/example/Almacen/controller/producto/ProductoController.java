package com.example.Almacen.controller.producto;

import com.example.Almacen.controller.producto.dto.DtoProducto;
import com.example.Almacen.models.producto.Producto;
import com.example.Almacen.models.user.User;
import com.example.Almacen.services.producto.ProductoServices;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-almacen/producto")
@CrossOrigin(origins = {"*"})
public class ProductoController {
    @Autowired
    private ProductoServices services;

    @GetMapping("/")
    public ResponseEntity<Response<List<Producto>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Producto>> getOne(@PathVariable Long id){
        return  new ResponseEntity<>(
                this.services.getOne(id),
                HttpStatus.OK
        );
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Response<Optional<Producto>>> getOneByName(@PathVariable String nombre){
        return new ResponseEntity<>(
                this.services.getOneByName(nombre),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Producto>> insert(@Valid @RequestBody DtoProducto producto,
                                                     @Valid BindingResult result){
        return new ResponseEntity<>(
                this.services.insert(producto.castToProdcuto()),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Producto>> update(@Valid @RequestBody DtoProducto producto,
                                                     @Valid BindingResult result){
        return new ResponseEntity<>(
                this.services.update(producto.castToProdcuto()),
                HttpStatus.OK
        );
    }
    @PutMapping("/aumento/{id}")
    public ResponseEntity<Response<Boolean>> update(@PathVariable Long id,@Valid @RequestBody DtoProducto cantidad,
                                                     @Valid BindingResult result){
        return new ResponseEntity<>(
                this.services.aumentoProducto(id,cantidad.getCantidad()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id){
        return  new ResponseEntity<>(
                this.services.delete(id),
                HttpStatus.OK
        );
    }
}
