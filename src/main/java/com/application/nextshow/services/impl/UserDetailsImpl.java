package com.application.nextshow.services.impl;

import com.application.nextshow.entities.User;
import com.application.nextshow.entities.enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

//this class is basically a custom implementation of User from out database in Spring Security

//this is how user is represented in our class


@Entity
@Data
@NoArgsConstructor
@Builder

public class UserDetailsImpl implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority > authorities;

    public UserDetailsImpl(UUID id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    //add  a build method which weill help to build UserDetailImpl
    //here, there are two instances of user one is from Spring Securities own User and Other one is the one we defined
    //purpose of this method is to convert our User Objects from the database to UserDetailsImpl object in spring security

    //it is just extracting role from our User object and convertin g into GrantedAuthority
    public  static UserDetailsImpl build(User user){
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

        if (user.getRole() == RoleType.ADMIN) {  // Assuming RoleType.ADMIN corresponds to admin role
            authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        }

        return  new UserDetailsImpl(
                user.getId(),
                user.getFirstname(),
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(authority)
        );

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
