package com.e17cn2.qlsv.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
  private Object data;
  private Object message;
  private Object status;
  private Object path;
}
