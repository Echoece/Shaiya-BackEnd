package com.example.shaiyav2.entity.gamedata;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class CharItems {
  @Id
  private long rowId;
  private long charId;
  private long itemId;
  private long itemUid;
  private long type;
  private long typeId;
  private long bag;
  private long slot;
  private long quality;
  private long gem1;
  private long gem2;
  private long gem3;
  private long gem4;
  private long gem5;
  private long gem6;
  private String craftname;
  private long count;
  private java.sql.Timestamp maketime;
  private String maketype;
  private String del;

  public CharItems() {
  }
}
