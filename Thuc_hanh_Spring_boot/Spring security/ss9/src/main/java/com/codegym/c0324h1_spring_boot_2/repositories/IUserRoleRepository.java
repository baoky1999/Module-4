package com.codegym.c0324h1_spring_boot_2.repositories;

import com.codegym.c0324h1_spring_boot_2.models.AppUser;
import com.codegym.c0324h1_spring_boot_2.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}