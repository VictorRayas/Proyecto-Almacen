package com.example.Almacen.auth.service;

import com.example.Almacen.models.user.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private RepositoryUser repository;
//com.maxivivienda.maxivivienda.models.user.User
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.example.Almacen.models.user.User> o = repository.findUserByUsername(username);
        System.out.println(repository.findUserByUsername(username));

        if(!o.isPresent()){
           throw  new UsernameNotFoundException(String.format("Username %s no existe en el sistema",username));
        }
        com.example.Almacen.models.user.User user= o.orElseThrow();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRol()));



        return new User(user.getUsername(),user.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }
}