package com.e17cn2.qlsv.repository;

import com.e17cn2.qlsv.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query(value = "select st from Student st, Stude where ")
    List<Student> findAllByClassRoomsId(int id);
}
