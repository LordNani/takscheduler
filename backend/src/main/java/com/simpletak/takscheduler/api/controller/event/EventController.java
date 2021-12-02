package com.simpletak.takscheduler.api.controller.event;

import com.simpletak.takscheduler.api.config.Response;
import com.simpletak.takscheduler.api.dto.event.EventDTO;
import com.simpletak.takscheduler.api.dto.event.NewEventDTO;
import com.simpletak.takscheduler.api.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @GetMapping("/{id}")
    public Response<EventDTO> getEvent(@PathVariable("id") UUID id) {
        return Response.success(eventService.findEventById(id));
    }

    @PostMapping
    public Response<EventDTO> createEvent(@Valid @RequestBody NewEventDTO eventDTO) {
        return Response.success(eventService.createEvent(eventDTO));
    }

    @PutMapping
    public Response<EventDTO> updateEvent(@Valid @RequestBody EventDTO eventDTO) {
        return Response.success(eventService.updateEvent(eventDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") UUID id) {
        eventService.deleteEvent(id);
    }
}