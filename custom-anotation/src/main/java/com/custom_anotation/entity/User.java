package com.custom_anotation.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String status;



}
