package com.machado.ederson.emarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="users")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@SequenceGenerator(name = "SEQ_U", sequenceName = "SEQ_USER", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_U")
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
