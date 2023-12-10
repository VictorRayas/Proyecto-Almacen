package com.example.Almacen.controller.proveedor;

import com.example.Almacen.controller.proveedor.dto.DtoProveedor;
import com.example.Almacen.models.proveedor.Proveedor;
import com.example.Almacen.services.proveedor.ProveedorServices;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-almacen/proveedor")
@CrossOrigin(origins = {"*"})
public class ProveedorController {
    @Autowired
    ProveedorServices services;

    @GetMapping("/")
    public ResponseEntity<Response<List<Proveedor>>> getALl(){
        return  new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Proveedor>> getOne(@PathVariable Long id){
        return  new ResponseEntity<>(
                this.services.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public  ResponseEntity<Response<Proveedor>> insert(@Valid @RequestBody DtoProveedor proveedor,
                                                       @Valid BindingResult result){
        return  new ResponseEntity<>(
                this.services.insert(proveedor.castToProveedor()),
                HttpStatus.OK
        );

    }

    @PutMapping("/")
    public ResponseEntity<Response<Proveedor>> update(@Valid @RequestBody DtoProveedor proveedor,
                                                      @Valid BindingResult result){
        return new ResponseEntity<>(
                this.services.update(proveedor.castToProveedor()),
                HttpStatus.OK
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.services.delete(id),
                HttpStatus.OK
        );
    }


}
