package com.example.demo.repositories;

import com.example.demo.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long>
{
    public Role findByRole(String role);
}