package com.min.app06.dto;

import java.sql.Date;

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
public class ContactDto {
  private int contact_id;
  private String last_name;
  private String first_name;
  private String email;
  private String mobile;
  private Date create_dt;
}
