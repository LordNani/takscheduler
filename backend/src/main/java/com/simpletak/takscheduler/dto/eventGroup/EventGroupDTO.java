package com.simpletak.takscheduler.dto.eventGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventGroupDTO{

    public EventGroupDTO(NewEventGroupDTO base, UUID id){
        this.eventGroupDescription = base.getEventGroupDescription();
        this.eventName = base.getEventName();
        this.ownerId = base.getOwnerId();
        this.id = id;
    }
    private String eventName;
    private String eventGroupDescription;
    private UUID ownerId;
    private UUID id;
}
