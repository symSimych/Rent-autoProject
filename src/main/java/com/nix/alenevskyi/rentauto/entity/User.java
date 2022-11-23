package com.nix.alenevskyi.rentauto.entity;


import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Column(name = "first_name")
    @NotBlank(message = "Firstname cannot be empty")
    String firstname;

    @Column(name = "last_name")
    @NotBlank(message = "Lastname cannot be empty")
    String lastname;

    @Id
    @Column(name = "email")
    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    String email;

    @Column(name = "phone_number")
    @NotBlank(message = "Phone number cannot be empty")
    String phoneNumber;

    @Column(name = "password")
    @NotBlank(message = "Password cannot be empty")
    String password;

    @Transient
    String confirmPassword;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "Roles",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUser(null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }
    public boolean isManager() {
        return roles.contains(Role.ROLE_MANAGER);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", roles=" + roles +
//                ", orders=" + orders +
                '}';
    }
}
