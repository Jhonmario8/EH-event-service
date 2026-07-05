package com.eh.eventservice.infrastructure.input.controller;

import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.handler.IEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{eventId}/open")
    public ResponseEntity<EventDTO> openEvent(@PathVariable Long eventId) {
        EventDTO dto = eventHandler.openEvent(eventId);
        return ResponseEntity.ok(dto);
    }
}
