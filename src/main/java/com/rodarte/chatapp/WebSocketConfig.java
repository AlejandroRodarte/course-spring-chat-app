package com.rodarte.chatapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // single endpoint to which our clients will access to connect to this server
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-websocket")
                .setAllowedOrigins("http://localhost:4200")
                .withSockJS();
    }

    // enableSimpleBroker prefix: used by the clients to subscribe to events
    // setApplicationDestinationPrefixes prefix: used by server to emit events
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/chat/");
        registry.setApplicationDestinationPrefixes("/app");
    }

}
