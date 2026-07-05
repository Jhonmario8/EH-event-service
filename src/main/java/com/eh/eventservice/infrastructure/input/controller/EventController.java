package com.eh.eventservice.infrastructure.input.controller;

import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.dto.EventResponseDTO;
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
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventResponseDTO dto = eventHandler.createEvent(eventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PatchMapping("/{eventId}/open")
    public ResponseEntity<EventResponseDTO> openEvent(@PathVariable Long eventId) {
        EventResponseDTO dto = eventHandler.openEvent(eventId);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventResponseDTO> updateEvent(@PathVariable Long eventId, @RequestBody EventDTO eventDTO) {
        EventResponseDTO dto = eventHandler.updateEvent(eventId, eventDTO);
        return ResponseEntity.ok(dto);
    }
}
