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
public class SemesterDTO {
  private int id;

  @JsonProperty("semester_name")
  private String semesterName;
}
