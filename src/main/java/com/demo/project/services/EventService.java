package com.demo.project.services;

import com.demo.project.dto.EventDto;
import com.demo.project.models.Event;

public interface EventService {

    Event saveEvent(Long clubId, EventDto event);
}
