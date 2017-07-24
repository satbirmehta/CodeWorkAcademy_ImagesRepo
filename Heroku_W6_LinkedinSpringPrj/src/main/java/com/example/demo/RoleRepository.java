package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 6/30/17.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {

    public Role findByRole(String role);

}
