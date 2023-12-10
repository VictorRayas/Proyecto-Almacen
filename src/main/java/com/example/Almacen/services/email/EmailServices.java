package com.example.Almacen.services.email;

import com.example.Almacen.models.email.Email;
import com.example.Almacen.models.inventory.Inventario;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.sql.SQLException;


@Service
public class EmailServices {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Transactional(rollbackFor = SQLException.class)
    public Response<Email> enviarEmail(Email datos) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setTo(datos.getReceptor());
            helper.setFrom(datos.getEmisor());
            helper.setSubject(datos.getTitulo());

            // Crear un contexto Thymeleaf para pasar datos a la plantilla
            Context thymeleafContext = new Context();
            thymeleafContext.setVariable("emisor", datos.getEmisor());
            thymeleafContext.setVariable("receptor", datos.getReceptor());
            thymeleafContext.setVariable("texto", datos.getTexto());
            thymeleafContext.setVariable("titulo", datos.getTitulo());

// Procesar la plantilla Thymeleaf
            String content = templateEngine.process("email-template", thymeleafContext);

            helper.setText(content, true);

            // Enviar el correo
            javaMailSender.send(mimeMessage);

            return new Response<>(
                    null,
                    false,
                    200,
                    "Email enviado con plantilla"
            );
        } catch (MessagingException e) {
            e.printStackTrace();  // Manejo adecuado de las excepciones en un entorno de producción
            return new Response<>(
                    null,
                    true,
                    500,
                    "Error al enviar el correo con plantilla"
            );
        }
    }
    @Transactional(rollbackFor = SQLException.class)
    public Response<Email> enviarEmailFallido(Email datos) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setTo(datos.getReceptor());
            helper.setFrom(datos.getEmisor());
            helper.setSubject(datos.getTitulo());

            // Crear un contexto Thymeleaf para pasar datos a la plantilla
            Context thymeleafContext = new Context();
            thymeleafContext.setVariable("emisor", datos.getEmisor());
            thymeleafContext.setVariable("receptor", datos.getReceptor());
            thymeleafContext.setVariable("texto", datos.getTexto());
            thymeleafContext.setVariable("titulo", datos.getTitulo());

// Procesar la plantilla Thymeleaf
            String content = templateEngine.process("email-template-fallido", thymeleafContext);

            helper.setText(content, true);

            // Enviar el correo
            javaMailSender.send(mimeMessage);

            return new Response<>(
                    null,
                    false,
                    200,
                    "Email enviado con plantilla"
            );
        } catch (MessagingException e) {
            e.printStackTrace();  // Manejo adecuado de las excepciones en un entorno de producción
            return new Response<>(
                    null,
                    true,
                    500,
                    "Error al enviar el correo con plantilla"
            );
        }
    }
}