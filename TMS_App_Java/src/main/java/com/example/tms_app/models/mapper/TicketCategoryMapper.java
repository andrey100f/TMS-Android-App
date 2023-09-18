package com.example.tms_app.models.mapper;

import com.example.tms_app.models.TicketCategory;
import com.example.tms_app.models.dto.TicketCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketCategoryMapper {
    public TicketCategoryMapper() {
    }

    public TicketCategoryDto convertModelToDto(TicketCategory ticketCategory) {
        TicketCategoryDto ticketCategoryDto = new TicketCategoryDto();
        ticketCategoryDto.setDescription(ticketCategory.getDescription());
        ticketCategoryDto.setPrice(ticketCategory.getPrice());
        return ticketCategoryDto;
    }

    public List<TicketCategoryDto> convertModelListToDtoList(List<TicketCategory> ticketCategories) {
        List<TicketCategoryDto> result = new ArrayList<>();
        for(TicketCategory ticketCategory: ticketCategories) {
            result.add(convertModelToDto(ticketCategory));
        }
        return result;
    }
}
