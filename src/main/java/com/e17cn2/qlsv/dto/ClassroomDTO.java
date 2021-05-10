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
public class ClassroomDTO {

  private int id;

  @JsonProperty("class_name")
  private String className;

  @JsonProperty("subject_id")
  private int subjectId;

  @JsonProperty("semester_id")
  private int semesterId;
}
