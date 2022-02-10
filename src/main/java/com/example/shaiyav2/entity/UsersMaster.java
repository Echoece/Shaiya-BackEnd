package com.example.shaiyav2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "Users_Master")
public class UsersMaster {
  @Id
  private long rowId;
  private long userUid;
  private String userId;
  private String pw;
  private java.sql.Timestamp joinDate;
  private String admin;
  private long adminLevel;
  private String useQueue;
  private long status;
  private long leave;
  private java.sql.Timestamp leaveDate;
  private String userType;
  private String userIp;
  private String modiIp;
  private java.sql.Timestamp modiDate;
  private long point;
  private String enpassword;
  private String birth;

  public UsersMaster() {
  }
}
