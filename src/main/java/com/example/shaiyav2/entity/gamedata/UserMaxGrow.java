package com.example.shaiyav2.entity.gamedata;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class UserMaxGrow {
  @Id
  private long rowId;
  private long serverId;
  private long userUid;
  private long country;
  private long maxGrow;
  private String del;

  public UserMaxGrow() {
  }
}
