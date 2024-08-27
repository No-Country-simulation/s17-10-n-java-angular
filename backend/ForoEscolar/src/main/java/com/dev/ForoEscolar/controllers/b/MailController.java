package com.dev.ForoEscolar.controllers.b;

import com.dev.ForoEscolar.dtos.c.EmailDTO;
import com.dev.ForoEscolar.dtos.c.EmailFileDTO;
import com.dev.ForoEscolar.services.oka.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class MailController {

    @Autowired
    private IEmailService emailService;

@PostMapping("/sendMenssage")
    public ResponseEntity <?> recibeRequestEmail(@RequestBody  EmailDTO emailDTO){

    System.out.println("Mensaje recibido: " + emailDTO);

        emailService.sendEmail(
                emailDTO.getToUser()
                ,emailDTO.getSubject()
                ,emailDTO.getMenssage());

    Map<String, String > response = new HashMap<>();
    response.put("estado","Enviado");
       return  ResponseEntity.ok(response);
    }

    @PostMapping("/sendMenssageFile")
    public ResponseEntity <?> recibeRequestEmailFile(@ModelAttribute EmailFileDTO emailFileDTO){

        System.out.println("Mensaje recibido: " + emailFileDTO);

        try {
            String fileName = emailFileDTO.getFile().getName();
            Path path = Paths.get("src/main/resources/files/" + fileName);
            Files.createDirectories(path.getParent());
            Files.copy(
                    emailFileDTO
                            .getFile()
                            .getInputStream(),
                    path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toFile();

            emailService.sendEmailFile(
                    emailFileDTO.getToUser(),
                    emailFileDTO.getSubject(),
                    emailFileDTO.getMenssage(),
                    file
            );

        Map<String, String > response = new HashMap<>();
        response.put("estado","Enviado");
        response.put("archivo","fileName");
        return  ResponseEntity.ok(response);


        }catch (Exception e){

            throw  new RuntimeException("Error al enviar el email con el archivo"+ e.getMessage());
        }



    }
}
