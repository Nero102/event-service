package cuttingsheeps.agendaservice.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import model.UpdatedEventDto;

public class UpdatedEventDtoMapper {

    ObjectMapper objectMapper = new ObjectMapper();

    public Event map(UpdatedEventDto eventDto) {
        return objectMapper.convertValue(eventDto, Event.class);
    }
}

