package com.example.Almacen.controller.email;

import com.example.Almacen.models.email.Email;
import com.example.Almacen.services.email.EmailServices;
import com.example.Almacen.services.email.EmailServices;
import com.example.Almacen.services.email.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api-almacen/email")
@CrossOrigin(origins = {"*"})
public class EmailController {
    @Autowired
    private EmailServices mail;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> enviarCorreo(@Valid @RequestBody Email datos,
                                          @Valid BindingResult result) {
        return new ResponseEntity<>(
                mail.enviarEmail(datos),
                HttpStatus.OK);
    }


    @PostMapping(value = "/fallido/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> enviarCorreoRechazado(@Valid @RequestBody Email datos,
                                                   @Valid BindingResult result){
        return  new ResponseEntity<>(
                mail.enviarEmailFallido(datos),
                HttpStatus.OK
        );
    }
}

