package com.eh.eventservice.infrastructure.input.controller;

import com.eh.eventservice.application.dto.EventCancelledDTO;
import com.eh.eventservice.application.dto.EventDTO;
import com.eh.eventservice.application.dto.EventResponseDTO;
import com.eh.eventservice.application.dto.PageResponseDTO;
import com.eh.eventservice.application.handler.IEventHandler;
import com.eh.eventservice.domain.model.EventStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping()
    public ResponseEntity<PageResponseDTO<EventResponseDTO>> getEvent(@RequestParam(required = false) Long categoryId,
                                                                      @RequestParam(required = false) String city,
                                                                      @RequestParam(required = false) LocalDate eventDate,
                                                                      @RequestParam(required = false) EventStatus status,
                                                                      @RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size) {

        return new ResponseEntity<>(eventHandler.getEvents(categoryId, city, eventDate, status, page, size), HttpStatus.OK);
    }

    @PatchMapping("/{eventId}/finish")
    public ResponseEntity<EventResponseDTO> finalizeEvent(@PathVariable Long eventId) {
        EventResponseDTO dto = eventHandler.finalizeEvent(eventId);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{eventId}/cancel")
    public ResponseEntity<EventCancelledDTO> cancelEvent(@PathVariable Long eventId) {
        EventCancelledDTO dto = eventHandler.cancelEvent(eventId);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable Long eventId) {
        EventResponseDTO dto = eventHandler.getEventById(eventId);
        return ResponseEntity.ok(dto);
    }

}
