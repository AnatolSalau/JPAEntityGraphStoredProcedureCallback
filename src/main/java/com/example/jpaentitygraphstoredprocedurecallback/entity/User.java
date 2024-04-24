package com.example.jpaentitygraphstoredprocedurecallback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.SEQUENCE)
      private long id;
      private String name;
      @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
      )
      private UserDetails details;

      public void setDetails(UserDetails details) {
            if (details == null) {
                  if (this.details != null){
                        this.details.setUser(null);
                  }
            } else {
                  details.setUser(this);
            }
            this.details = details;
      }
}