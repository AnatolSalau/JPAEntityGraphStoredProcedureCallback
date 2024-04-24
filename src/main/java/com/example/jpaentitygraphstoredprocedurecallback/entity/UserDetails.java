package com.example.jpaentitygraphstoredprocedurecallback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class UserDetails {
      @Id
      private long id;
      private String phone;
      @OneToOne(fetch = FetchType.LAZY)
      @MapsId
      @JoinColumn(name = "id")
      private User user;
// getters/setters/constructors
}