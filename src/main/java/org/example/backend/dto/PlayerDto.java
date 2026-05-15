package org.example.backendkelaspbo.dto;

import org.example.backendkelaspbo.enums.MowerColor;
import org.example.backendkelaspbo.enums.PowerUpType;

public record PlayerDto(
        Long id,
        String name,
        MowerColor color,
        boolean isHost,
        int lives,
        int grassCut,
        int posX,
        int posY,
        String direction,
        boolean alive,
        boolean crashed,
        boolean speedBoosted,
        PowerUpType heldPowerUp
) {}
