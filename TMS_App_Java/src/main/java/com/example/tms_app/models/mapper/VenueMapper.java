package com.example.tms_app.models.mapper;

import com.example.tms_app.models.Venue;
import com.example.tms_app.models.dto.VenueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VenueMapper {

    public VenueMapper() {
    }

    public VenueDto convertModelToDto(Venue venue) {
        VenueDto venueDto = new VenueDto();
        venueDto.setLocation(venue.getLocation());
        venueDto.setType(venue.getType());
        venueDto.setCapacity(venue.getCapacity());
        return venueDto;
    }

    public List<VenueDto> convertModelListToDtoList(List<Venue> venues) {
        List<VenueDto> result = new ArrayList<>();
        for(Venue venue:venues) {
            result.add(convertModelToDto(venue));
        }
        return result;
    }
}
