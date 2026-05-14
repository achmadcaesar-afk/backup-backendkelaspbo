package org.example.backend.enums;

public enum GamePhase {
    COUNTDOWN,  // Hitung mundur 3-2-1
    PLAYING,    // Sedang bermain
    QUIZ,       // Pemain kalah sedang kuis
    ROUND_END,  // Akhir ronde, transisi
    GAME_OVER   // Game selesai
}
