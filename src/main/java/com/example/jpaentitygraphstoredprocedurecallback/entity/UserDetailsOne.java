package com.example.jpaentitygraphstoredprocedurecallback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class UserDetailsOne {
      @Id
      private long id;
      private String phone;
}