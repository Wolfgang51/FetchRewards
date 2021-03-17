package com.example.fetchrewards.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
public class Payer {

  private @Id
  @GeneratedValue
  @Getter(onMethod_ = @JsonIgnore)
  @Setter
  Long id;
  @Getter
  @Setter
  private String payer;
  @Getter
  @Setter
  private int points;

  public Payer() {
  }

  public Payer(String payer, int points) {
    this.payer = payer;
    this.points = points;
  }
}
