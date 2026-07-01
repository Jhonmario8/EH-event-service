package com.eh.eventservice.infrastructure.input.controller;

import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.handler.IEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final IEventHandler eventHandler;

    @PostMapping()
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventDTO dto = eventHandler.createEvent(eventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


}
