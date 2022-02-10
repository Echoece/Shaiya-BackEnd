package com.example.shaiyav2.entity.chatlog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class ChatLog {
  @Id
  private long row;
  private String userUid;
  private String charId;
  private String chatType;
  private String targetName;
  private String chatData;
  private String mapId;
  private String chatTime;

  public ChatLog() {
  }
}
