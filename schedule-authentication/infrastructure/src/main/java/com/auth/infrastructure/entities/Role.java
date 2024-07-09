package com.auth.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_seq_gen",
            sequenceName = "role_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_gen")
    private Integer id;

    private String name;
}