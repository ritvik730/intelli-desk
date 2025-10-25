package com.intellidesk.ticketService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "tickets")
@Builder
public class Ticket {

    @Id
    private String id;
    private String ticketId;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String assignee;
    private String reporter;

}
