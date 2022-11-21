package com.neosoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private int userId;
    @Column
    private String userName;
    @Column
    private String password;

    public <E> User(String abc, String password, ArrayList<E> es) {
    }

    public void addAttriutes(String listUsers, String listUsers1) {
    }
}
