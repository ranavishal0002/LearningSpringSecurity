package com.example.SpringSecurity.entity;

//import com.example.demo4.SecurityApp.entities.enums.Role;
import com.example.SpringSecurity.entity.enums.Permission;
import com.example.SpringSecurity.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;

//    private Role role;                               // this is when we want one role per user

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)                      // otherwise role will be stored in numbers like 0,1,2 in the DB
    private Set<Role> roles;                            // Now one user can have more than one role


    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Permission>permissions;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority>authorities= roles.stream()
                .map(roles -> new SimpleGrantedAuthority(roles.name()))
                .collect(Collectors.toSet());
        permissions.forEach(
                permission -> authorities.add(new SimpleGrantedAuthority(permission.name()))
        );
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}




