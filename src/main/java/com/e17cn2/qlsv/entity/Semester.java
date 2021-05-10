package com.e17cn2.qlsv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "semester_name")
    private String semesterName;

    @OneToMany(mappedBy = "semester")
    private List<ClassRoom> classRooms;

    @OneToMany(mappedBy = "semester")
    private List<Point> points;
}
