package com.min.myapp.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommentDto {
  private int bComId;
  private String bComContents;
  private Timestamp bCodifyDt;
  private Timestamp bCreateDt;
  private BlogDto blogDto;
}
