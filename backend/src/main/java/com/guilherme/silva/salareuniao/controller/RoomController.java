package com.guilherme.silva.salareuniao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.guilherme.silva.salareuniao.exception.ResourceNotFoundException;
import com.guilherme.silva.salareuniao.model.Room;
import com.guilherme.silva.salareuniao.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAlRooms() {
        return roomRepository.findAll();        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id) throws ResourceNotFoundException{
        Room room = roomExists(id);
        return ResponseEntity.ok().body(room);
        
    }

 

    @PostMapping
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Room> updateRoom(@PathVariable("id") Long id, @Valid @RequestBody Room room) throws ResourceNotFoundException {
        roomExists(id);
        room.setId(id);
        return ResponseEntity.ok().body(roomRepository.save(room));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable("id") Long id) throws ResourceNotFoundException {
        roomExists(id);
        roomRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        
    }
    
    private Room roomExists(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found for this id:"+ id));
    }
}