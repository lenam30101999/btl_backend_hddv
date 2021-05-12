package com.e17cn2.qlsv.response;

import com.e17cn2.qlsv.dto.SemesterDTO;
import com.e17cn2.qlsv.dto.SubjectDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PointResponse {
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

  @JsonProperty("subject")
  private SubjectResponse subjectResponse;

  @JsonProperty("semester")
  private SemesterResponse semesterResponse;
}
