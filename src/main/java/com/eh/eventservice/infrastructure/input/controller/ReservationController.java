package com.eh.eventservice.infrastructure.input.controller;

import com.eh.eventservice.application.dto.*;
import com.eh.eventservice.application.handler.IReservationHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationHandler reservationHandler;

    @PostMapping()
    public ResponseEntity<ReservationResponseDTO> createReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        ReservationResponseDTO response = reservationHandler.createReservation(reservationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationCancelledDTO> cancelReservation(@PathVariable Long id) {
        ReservationCancelledDTO response = reservationHandler.cancelReservation(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<PageResponseDTO<MyReservationResponseDTO>> getReservationsByClientId(@RequestParam(defaultValue = "0") int page,
                                                                                               @RequestParam(defaultValue = "10") int size) {
        PageResponseDTO<MyReservationResponseDTO> response = reservationHandler.getReservationsByClientId(page, size);
        return ResponseEntity.ok(response);
    }


}
