package com.roomer.app.api;

import com.roomer.app.domain.Room;
import com.roomer.app.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RoomsController {

    @NonNull
    private RoomService roomService;
    private String sortBy;

    @GetMapping(value = "/rooms")
    public String showRoomsHTML(@RequestParam(required = false, defaultValue = "noSorting") String sortBy) {
        this.sortBy = sortBy;
        return "roomsListing";
    }
    @GetMapping(value = "/roomsList")
    public ResponseEntity<List<Room>> showRooms() {
        List<Room> roomList = roomService.getAllRooms(this.sortBy);
        return ResponseEntity.ok(roomList);
    }


}
