package com.eh.eventservice.application.handler;


import com.eh.eventservice.application.dto.EventDTO;

public interface IEventHandler {
    EventDTO createEvent(EventDTO eventDTO);
}
