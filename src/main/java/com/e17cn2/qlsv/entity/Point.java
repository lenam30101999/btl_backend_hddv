package com.e17cn2.qlsv.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "point")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "attendance_point")
    private float attendancePoint;
    @Column(name = "test_point")
    private float testPoint;
    @Column(name = "project_point")
    private float projectPoint;
    @Column(name = "final_point")
    private float finalPoint;
    @Column(name = "avg_point")
    private float avgPoint;

}
