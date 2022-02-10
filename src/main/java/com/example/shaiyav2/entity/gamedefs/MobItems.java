package com.example.shaiyav2.entity.gamedefs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class MobItems {
  @Id
  private long rowId;
  private long mobId;
  private long itemOrder;
  private long grade;
  private long dropRate;

  public long getRowId() {
    return rowId;
  }

  public void setRowId(long rowId) {
    this.rowId = rowId;
  }

}
