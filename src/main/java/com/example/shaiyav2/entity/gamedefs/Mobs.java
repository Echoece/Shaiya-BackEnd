package com.example.shaiyav2.entity.gamedefs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Mobs {
  @Id
  private long rowId;
  private long mobId;
  private String mobName;
  private long level;
  private long exp;
  private long ai;
  private long money1;
  private long money2;
  private long questItemId;
  private long hp;
  private long sp;
  private long mp;
  private long dex;
  private long wis;
  private long luc;
  private long day;
  private long size;
  private long attrib;
  private long defense;
  private long magic;
  private long resistState1;
  private long resistState2;
  private long resistState3;
  private long resistState4;
  private long resistState5;
  private long resistState6;
  private long resistState7;
  private long resistState8;
  private long resistState9;
  private long resistState10;
  private long resistState11;
  private long resistState12;
  private long resistState13;
  private long resistState14;
  private long resistState15;
  private long resistSkill1;
  private long resistSkill2;
  private long resistSkill3;
  private long resistSkill4;
  private long resistSkill5;
  private long resistSkill6;
  private long normalTime;
  private long normalStep;
  private long chaseTime;
  private long chaseStep;
  private long chaseRange;
  private long attackType1;
  private long attackTime1;
  private long attackrange1;
  private long attack1;
  private long attackplus1;
  private long attackattrib1;
  private long attackspecial1;
  private long attackok1;
  private long attacktype2;
  private long attacktime2;
  private long attackrange2;
  private long attack2;
  private long attackplus2;
  private long attackattrib2;
  private long attackspecial2;
  private long attackok2;
  private long attacktype3;
  private long attacktime3;
  private long attackrange3;
  private long attack3;
  private long attackplus3;
  private long attackattrib3;
  private long attackspecial3;
  private long attackok3;

}
