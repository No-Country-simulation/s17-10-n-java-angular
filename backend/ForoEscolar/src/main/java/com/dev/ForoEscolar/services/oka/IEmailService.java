package com.dev.ForoEscolar.services.oka;

import java.io.File;

public interface IEmailService {
    void sendEmail (String [] toUser,String subjet,String menssage);
    void sendEmailFile (
            String [] toUser,
            String subjet,
            String menssage,
            File file
    ); //para enviar los boletines

}
