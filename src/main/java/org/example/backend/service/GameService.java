package org.example.backendkelaspbo.service;

import org.example.backendkelaspbo.dto.*;
import org.example.backendkelaspbo.entity.Player;
import org.example.backendkelaspbo.entity.Room;
import org.example.backendkelaspbo.enums.GamePhase;
import org.example.backendkelaspbo.enums.PowerUpType;
import org.example.backendkelaspbo.enums.RoomStatus;
import org.example.backendkelaspbo.game.BombProjectile;
import org.example.backendkelaspbo.game.GameSession;
import org.example.backendkelaspbo.game.PlayerGameState;
import org.example.backendkelaspbo.powerup.PowerUp;
import org.example.backendkelaspbo.powerup.PowerUpFactory;
import org.example.backendkelaspbo.quiz.QuizBank;
import org.example.backendkelaspbo.quiz.QuizQuestion;
import org.example.backendkelaspbo.repository.PlayerRepository;
import org.example.backendkelaspbo.repository.RoomRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service utama logika game.
 * Menerapkan semua 4 pilar OOP:
 * - ENCAPSULATION: state tersembunyi, akses via method
 * - INHERITANCE: menggunakan entity yang mewarisi BaseEntity
 * - ABSTRACTION: menggunakan QuizQuestion interface & PowerUp abstract class
 * - POLYMORPHISM: PowerUpFactory return PowerUp, QuizBank return QuizQuestion
 */
@Service
public class GameService {

    private final RoomRepository roomRepository;
    private final PlayerRepository playerRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private final QuizBank quizBank;
    private final PowerUpFactory powerUpFactory;
    private final Random random = new Random();

    