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
public class StudentDTO {

    private int id;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("student_code")
    private String studentCode;

}
