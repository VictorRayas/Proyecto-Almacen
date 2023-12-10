package com.example.Almacen.controller.inventory;

import com.example.Almacen.controller.inventory.dto.DtoInventario;
import com.example.Almacen.models.inventory.Inventario;
import com.example.Almacen.services.inventory.InventarioService;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-almacen/inventario")
@CrossOrigin(origins = {"*"})
public class InventarioController {
    @Autowired
    private InventarioService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Inventario>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Inventario>> getOne(@PathVariable Long id){
        return  new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Inventario>> insert(@Valid @RequestBody DtoInventario inventario,
                                                       @Valid BindingResult result){
        return  new ResponseEntity<>(
                this.service.insert(inventario.castToInventario()),
                HttpStatus.OK

        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Inventario>> update(@Valid @RequestBody DtoInventario inventario,
                                                       @Valid BindingResult result){
        return new ResponseEntity<>(
                this.service.update(inventario.castToInventario()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> update(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
