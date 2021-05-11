package com.e17cn2.qlsv.repository;

import com.e17cn2.qlsv.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
  Optional<Point> findPointById(int id);

  List<Point> findPointsByStudentIdOrderBySemesterId(int studentId);
}
