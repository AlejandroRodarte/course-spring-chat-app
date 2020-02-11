package com.rodarte.chatapp.controllers;

import com.rodarte.chatapp.models.documents.Mensaje;
import com.rodarte.chatapp.models.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatController {

    private String[] colores = { "red", "blue", "green", "magenta", "purple", "orange" };

    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // @MessageMapping for /app/mensaje: Listen for clients emitting the /app/mensaje event
    // expected payload is an object of type Mensaje
    // @SendTo for /chat/mensaje for server to emit data to subscribed clients, sending back a Mensaje object
    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibirMensaje(Mensaje mensaje) {

        mensaje.setFecha(new Date().getTime());

        if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
            mensaje.setTexto("nuevo usuario");
            mensaje.setColor(colores[new Random().nextInt(colores.length)]);
        } else {
            chatService.guardar(mensaje);
        }

        return mensaje;

    }

    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String estaEscribiendo(String username) {
        return username + " esta escribiendo...";
    }

}
