package com.roomer.app.api;

import com.roomer.app.domain.Account;
import com.roomer.app.domain.Room;
import com.roomer.app.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class ListRoomsController {

    private RoomService roomService;
    @GetMapping(value = "/rooms")
    public ResponseEntity<List<Room>> showRooms(Model model) {
        List<Room> roomList= roomService.getAllRooms();
        return ResponseEntity.ok(roomList);
    }

}
