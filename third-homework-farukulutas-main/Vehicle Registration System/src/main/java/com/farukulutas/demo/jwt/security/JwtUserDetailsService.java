package com.farukulutas.demo.jwt.security;

import com.farukulutas.demo.entity.User;
import com.farukulutas.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService cusCustomerEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = cusCustomerEntityService.findByUsername(username);

        return JwtUserDetails.create(user);
    }

    public UserDetails loadByUserId(Long id) throws Exception {

        User cusCustomer = cusCustomerEntityService.findByIdWithControl(id);

        return JwtUserDetails.create(cusCustomer);
    }
}
