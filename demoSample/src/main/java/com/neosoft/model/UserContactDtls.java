package com.neosoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contact_Dtl")
public class UserContactDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int cId;
    @Column
    private Long mobileNumber;
    @Column
    private Long tel;

}
