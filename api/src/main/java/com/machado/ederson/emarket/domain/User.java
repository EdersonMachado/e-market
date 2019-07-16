package com.machado.ederson.emarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_USER", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private String photoUrl;

    @JsonIgnore
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Profile profile;

}
