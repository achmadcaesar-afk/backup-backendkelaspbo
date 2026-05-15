package org.example.backendkelaspbo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.backendkelaspbo.enums.MowerColor;

public record CreateRoomRequest(
        @NotBlank @Size(min = 1, max = 20) String playerName,
        @NotNull MowerColor color
) {}
