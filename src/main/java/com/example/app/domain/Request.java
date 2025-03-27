package com.example.app.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Request {
    private Integer id;
    private String teamId;
    @NotBlank
    @Size(max = 30)
    private String title;
    @NotBlank
    private String content;
    private String status; // PENDING / APPROVED / REJECTED
    private String responseNote;
    private LocalDateTime requestedAt;
}
