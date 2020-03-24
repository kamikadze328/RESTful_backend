package com.kamikadze328.testforcv.test2.repositories;

import com.kamikadze328.testforcv.test2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
