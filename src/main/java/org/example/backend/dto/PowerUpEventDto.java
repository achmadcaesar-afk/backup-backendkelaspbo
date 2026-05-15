package org.example.backendkelaspbo.dto;

import org.example.backendkelaspbo.enums.PowerUpType;

public record PowerUpEventDto(
        Long playerId,
        PowerUpType type,
        int posX,
        int posY,
        boolean autoActivated
) {}
