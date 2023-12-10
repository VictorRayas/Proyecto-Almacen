package com.example.Almacen.controller.Registro;

import com.example.Almacen.controller.Registro.dto.DtoRegistro;
import com.example.Almacen.controller.proveedor.dto.DtoProveedor;
import com.example.Almacen.models.proveedor.Proveedor;
import com.example.Almacen.models.registro.Registro;
import com.example.Almacen.services.Registro.RegistroService;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-almacen/registro")
@CrossOrigin(origins = {"*"})
public class RegistroController {
    @Autowired
    RegistroService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Registro>>> getALl(){
        return  new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public  ResponseEntity<Response<Registro>> insert(@Valid @RequestBody DtoRegistro registro,
                                                       @Valid BindingResult result){
        return  new ResponseEntity<>(
                this.service.insert(registro.castToCast()),
                HttpStatus.OK
        );

    }


}
