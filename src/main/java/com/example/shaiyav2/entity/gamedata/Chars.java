package com.example.shaiyav2.entity.gamedata;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Chars {

  private long serverId;
  private String userId;
  private long userUid;
  @Id
  private long charId;
  private String charName;
  @Column(name = "New")
  private long neW;
  private long del;
  private long slot;
  private long family;
  private long grow;
  private long hair;
  private long face;
  private long size;
  private long job;
  private long sex;
  private long level;
  private long statPoint;
  private long skillPoint;
  private long str;
  private long dex;
  private long rec;
  @Column(name = "Int")
  private long inT;
  private long luc;
  private long wis;
  private long hp;
  private long mp;
  private long sp;
  private long map;
  private long dir;
  private long exp;
  private long money;
  private double posX;
  private double posY;
  private double posz;
  private long hg;
  private long vg;
  private long cg;
  private long og;
  private long ig;
  // player kills
  private long k1;
  // player death
  private long k2;
  // victory
  private long k3;
  // defeat
  private long k4;
  private long killLevel;
  private long deadLevel;
  private java.sql.Timestamp regDate;
  private java.sql.Timestamp deleteDate;
  private java.sql.Timestamp joinDate;
  private java.sql.Timestamp leaveDate;
  private long renameCnt;
  private String oldCharName;
  private long remainTime;
  private long loginStatus;

  public Chars() {
  }
}
