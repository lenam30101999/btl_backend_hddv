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
public class SubjectDTO {
  
  private int id;
  
  @JsonProperty( "subject_name")
  private String subjectName;

  @JsonProperty( "attendance_percent")
  private float attendancePercent;

  @JsonProperty( "test_percent")
  private float testPercent;

  @JsonProperty( "project_percent")
  private float projectPercent;

  @JsonProperty( "final_percent")
  private float finalPercent;
}
