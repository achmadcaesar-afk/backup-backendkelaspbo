package org.example.backendkelaspbo.repository;

import org.example.backendkelaspbo.entity.Room;
import org.example.backendkelaspbo.enums.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByCode(String code);
    boolean existsByCode(String code);
    void deleteByStatus(RoomStatus status);
}
