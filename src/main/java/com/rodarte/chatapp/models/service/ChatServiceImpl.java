package com.rodarte.chatapp.models.service;

import com.rodarte.chatapp.models.dao.ChatRepository;
import com.rodarte.chatapp.models.documents.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChatServiceImpl implements ChatService {

    private ChatRepository chatRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<Mensaje> obtenerUltimos10Mensajes() {
        return chatRepository.findFirst10ByOrderByFechaDesc();
    }

    @Override
    public Mensaje guardar(Mensaje mensaje) {
        return chatRepository.save(mensaje);
    }

}
