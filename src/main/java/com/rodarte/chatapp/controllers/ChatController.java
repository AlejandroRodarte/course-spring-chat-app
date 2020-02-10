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
    @SendTo("/chat/mensage")
    public Mensaje recibirMensaje(Mensaje mensaje) {
        mensaje.setFecha(new Date().getTime());
        mensaje.setTexto("Recibido por el broker: " + mensaje.getTexto());
        return mensaje;
    }

}
