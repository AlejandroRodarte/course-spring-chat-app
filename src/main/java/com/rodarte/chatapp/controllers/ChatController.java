package com.rodarte.chatapp.controllers;

import com.rodarte.chatapp.models.documents.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    // @MessageMapping for /app/mensaje: Listen for clients emitting the /app/mensaje event
    // expected payload is an object of type Mensaje
    // @SendTo for /chat/mensaje for server to emit data to subscribed clients, sending back a Mensaje object
    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibirMensaje(Mensaje mensaje) {

        mensaje.setFecha(new Date().getTime());

        if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
            mensaje.setTexto("nuevo usuario");
        }

        return mensaje;

    }

}
