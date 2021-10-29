package com.simpletak.takscheduler.dto.eventGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventGroupDTO {
    private UUID id;
    private String eventName;
    private String eventGroupDescription;
    private UUID ownerId;
}
