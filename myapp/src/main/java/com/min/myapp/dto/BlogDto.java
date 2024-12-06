package com.min.myapp.dto;

import java.sql.Date;
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
public class BlogDto {
  private int blog_id;
  private String title;
  private String contents;
  private String user_email;
  private int hit;
  private java.sql.Timestamp modify_dt;
  private Timestamp criate_dt;
}
