package com.example.Almacen.controller.vale;


import com.example.Almacen.controller.user.dto.DtoUser;
import com.example.Almacen.controller.vale.dto.DtoVale;
import com.example.Almacen.models.user.User;
import com.example.Almacen.models.vale.Vale;
import com.example.Almacen.services.vale.ValeServices;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-almacen/vale")
@CrossOrigin(origins = {"*"})
public class ValeController {
    @Autowired
    private  ValeServices services;

    @GetMapping("/")
    public ResponseEntity<Response<List<Vale>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Vale>> insert(@Valid @RequestBody DtoVale vale,
                                                 @Valid BindingResult result){
        System.out.println("COntroller");
        System.out.println(result);
        System.out.println(vale);
        System.out.println(vale.castToCast());
        return  new ResponseEntity<>(
                this.services.Insert(vale.castToCast()),
                HttpStatus.OK
        );

    }

    @PutMapping("/")
    public ResponseEntity<Response<Vale>> update(@Valid @RequestBody DtoVale vale,
                                                 @Valid BindingResult result){

        return new ResponseEntity<>(
                this.services.update(vale.castToCast()),
                HttpStatus.OK
        );
    }

}
