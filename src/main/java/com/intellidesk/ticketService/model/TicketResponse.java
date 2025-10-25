package com.intellidesk.ticketService.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketResponse {

    private String ticketId;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String assignee;
    private String reporter;
}
