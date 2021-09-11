package com.guilherme.silva.salareuniao.repository;

import com.guilherme.silva.salareuniao.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    
}
