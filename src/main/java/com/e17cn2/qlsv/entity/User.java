package com.e17cn2.qlsv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "username")
    protected String username;
    @Column(name = "password")
    protected String password;
    @Column(name = "role_name")
    protected String roleName;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Manager manager;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Student student;
    @Column(name = "uid", unique = true, nullable = false)
    private String uid;

}
