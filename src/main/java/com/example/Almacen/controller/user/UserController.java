package com.example.Almacen.controller.user;

import com.example.Almacen.controller.user.dto.DtoUser;
import com.example.Almacen.models.user.User;
import com.example.Almacen.services.user.UserServices;
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
@RequestMapping("/api-almacen/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    private UserServices services;

    @GetMapping("/")
    public ResponseEntity<Response<List<User>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<User>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(
                this.services.getOne(id),
                HttpStatus.OK
        );
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Response<Optional<User>>> getOneByName(@PathVariable String nombre){
        return new ResponseEntity<>(
                this.services.getOneByName(nombre),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public  ResponseEntity<Response<User>> insert(@Valid @RequestBody DtoUser user,
                                                  @Valid BindingResult result){
        return  new ResponseEntity<>(
                this.services.Insert(user.castToCast()),
                HttpStatus.OK
        );

    }

    @PutMapping("/")
    public ResponseEntity<Response<User>> update(@Valid @RequestBody DtoUser user,
                                                 @Valid BindingResult result){
        return new ResponseEntity<>(
                this.services.update(user.castToCast()),
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
