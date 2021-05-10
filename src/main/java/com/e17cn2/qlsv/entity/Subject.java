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
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "attendance_percent")
    private float attendancePercent;
    @Column(name = "test_percent")
    private float testPercent;
    @Column(name = "project_percent")
    private float projectPercent;
    @Column(name = "final_percent")
    private float finalPercent;

}
