package com.e17cn2.qlsv.repository;

import com.e17cn2.qlsv.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
  List<ClassRoom> findAllBySemesterId(int semesterId);
}
