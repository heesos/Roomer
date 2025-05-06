package com.roomer.app.api;

import com.roomer.app.domain.Room;
import com.roomer.app.service.RoomService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RoomsController {

    // workflow of this controller:
    // basically it is responsible for communication with the end user experience
    // we have one controller here that is responsible for generating the page, also this controller takes url parameters
    // and stores them. It allows for future usage of them for instance if we want to sort stuff.

    // example flow: user click on page -> returning roomsListing.html -> the .js script on that page is fetching data
    // from the /roomsListing endpoint and populating the list

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
