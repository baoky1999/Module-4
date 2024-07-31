package com.codegym.c0324h1_spring_boot_2.services.impl;

import com.codegym.c0324h1_spring_boot_2.dtos.UserInfoUserDetails;
import com.codegym.c0324h1_spring_boot_2.models.AppUser;
import com.codegym.c0324h1_spring_boot_2.models.UserRole;
import com.codegym.c0324h1_spring_boot_2.repositories.IUserRepository;
import com.codegym.c0324h1_spring_boot_2.repositories.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
//        Lấy tất cả role của AppUser
        List<UserRole> userRoles = iUserRoleRepository.findAllByAppUser(appUser);
        UserInfoUserDetails infoUserDetails = new UserInfoUserDetails(appUser, userRoles);
        return infoUserDetails;
    }
}
