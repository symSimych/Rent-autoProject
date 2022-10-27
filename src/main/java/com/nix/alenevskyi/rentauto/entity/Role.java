package com.nix.alenevskyi.rentauto.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = {"name"})
@Entity
@Table(name = "Roles", schema = "public")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    UUID id;

    @Column(name = "role_name")
    String name;

    @ManyToMany(mappedBy = "roles")
    Set<User> users = new HashSet<>();
}
