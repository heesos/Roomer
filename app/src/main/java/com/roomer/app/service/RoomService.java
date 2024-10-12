package com.roomer.app.service;

import com.roomer.app.domain.Room;
import com.roomer.app.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for business logic when performing database operations with Room entity
 *
 * @author milosz.marzec
 */

@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;

    /**
     * Saves a new Room to the database
     *
     * @param room Room entity
     * @return created Room in database
     */
    public Room saveRoom(Room room) {
        roomRepository.save(room);
        return room;
    }

    /**
     * Searches for all Rooms in database
     *
     * @return list of Rooms
     */
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    /**
     * Removes Room from database
     *
     * @param id id of Room to remove
     */

    public void removeRoomById(long id) {
        roomRepository.deleteById(id);
    }

    /**
     * Gets Room from database by id
     *
     * @param id Room id
     * @return Room object
     */
    public Room getRoomById(long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
