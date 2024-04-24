package com.example.jpaentitygraphstoredprocedurecallback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class UserOne {
      @Id
      @GeneratedValue(strategy = GenerationType.SEQUENCE)
      private long id;
      private String name;
      @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
      )
      @JoinColumn(name = "details_id", referencedColumnName = "id")
      private UserDetailsOne details;

      public void setDetails(UserDetailsOne details) {

            this.details = details;
      }
}