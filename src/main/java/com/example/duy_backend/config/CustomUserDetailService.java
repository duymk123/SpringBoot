package com.example.duy_backend.config;

import com.example.duy_backend.entity.Users;
import com.example.duy_backend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService { //get detail user ( noi cho spring security biet username/password nao dc di vao he thong)
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        Enum role = user.getRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role); // ROLE_ADMIN - ROLE_CUSTOMER

        // GrantedAuthority la mot cach phan quyen
        // - ROLE (ADMIN/CUSTOMER) => ROLE_ADMIN, ROLE_CUSTOMER


        return new User(username, user.getPassword(), List.of(authority));
    }

//    public static void  main(String[] args) {
//    $2a$10$mhDvmG9fYan.dWemTntegu9XlQVuLk9kr86vZzvGH0geoOaGAH6ue
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("123456"));
//    }
}
