package com.roomer.app.service;

import com.roomer.app.domain.Room;
import com.roomer.app.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
     * Optional: they can be sorted based on the URL parameter: price_asc, price_dsc,
     * creation_date_asc, creation_date_desc
     *
     * @param  sortBy defines the value to sortBy
     * @return list of Rooms
     */
    public List<Room> getAllRooms(String sortBy) {
        List<Room> roomList = Collections.emptyList();

        switch (sortBy) {
            case "noSorting":
                roomList = roomRepository.findAll();
                break;
            case "price_asc":
                roomList = roomRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
                break;
            case "price_desc":
                roomList = roomRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
                break;
            case "date_asc":
                roomList = roomRepository.findAll(Sort.by(Sort.Direction.ASC, "creationDate"));
            break;
            case "date_desc":
                roomList = roomRepository.findAll(Sort.by(Sort.Direction.DESC, "creationDate"));
                break;
        }
        return roomList;
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
