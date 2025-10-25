package com.intellidesk.ticketService.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketDto {

    private String title;
    private String description;
    private String status;
    private String priority;
    private String assignee;
    private String reporter;
}
