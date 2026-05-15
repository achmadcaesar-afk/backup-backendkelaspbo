package org.example.backendkelaspbo.dto;

import org.example.backendkelaspbo.enums.RoomStatus;

import java.util.List;

public record RoomDto(
        Long id,
        String code,
        RoomStatus status,
        int currentRound,
        List<PlayerDto> players,
        Long myPlayerId
) {}
