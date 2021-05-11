package com.e17cn2.qlsv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class PointDTO {

  private int id;

  @JsonProperty("attendance_point")
  private float attendancePoint;

  @JsonProperty("test_point")
  private float testPoint;

  @JsonProperty("project_point")
  private float projectPoint;

  @JsonProperty("final_point")
  private float finalPoint;

  @JsonProperty("avg")
  private float avg;

  @JsonProperty("student_id")
  private int studentId;

  @JsonProperty("semester_id")
  private int semesterId;

  @JsonProperty("manager_id")
  private int managerId;

  @JsonProperty("subject_id")
  private int subjectId;

}
