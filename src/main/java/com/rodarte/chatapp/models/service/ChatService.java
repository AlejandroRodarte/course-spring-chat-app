package com.rodarte.chatapp.models.service;

import com.rodarte.chatapp.models.documents.Mensaje;

import java.util.List;

public interface ChatService {
    List<Mensaje> obtenerUltimos10Mensajes();
    Mensaje guardar(Mensaje mensaje);
}
