package com.example.shaiyav2.entity.gamedefs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Items {

  @Id
  private long rowId;
  private long itemId;
  private String itemName;
  private long type;
  private long typeId;
  private long reqlevel;
  private long country;
  private long attackfighter;
  private long defensefighter;
  private long patrolrogue;
  private long shootrogue;
  private long attackmage;
  private long defensemage;
  private long grow;
  private long reqStr;
  private long reqDex;
  private long reqRec;
  private long reqInt;
  private long reqWis;
  private long reqluc;
  private long reqVg;
  private long reqOg;
  private long reqIg;
  private long range;
  private long attackTime;
  private long attrib;
  private long special;
  private long slot;
  private long quality;
  private long effect1;
  private long effect2;
  private long effect3;
  private long effect4;
  private long constHp;
  private long constSp;
  private long constMp;
  private long constStr;
  private long constDex;
  private long constRec;
  private long constInt;
  private long constWis;
  private long constLuc;
  private long speed;
  private long exp;
  private long buy;
  private long sell;
  private long grade;
  private long drop;
  private long server;
  private long count;

  public Items() {
  }
}
