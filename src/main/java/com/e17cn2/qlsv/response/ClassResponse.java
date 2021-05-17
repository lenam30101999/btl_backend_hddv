package com.e17cn2.qlsv.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ClassResponse {
    private int id;

    @JsonProperty("class_name")
    private String className;

    @JsonProperty("subject_id")
    private int subjectId;

}
