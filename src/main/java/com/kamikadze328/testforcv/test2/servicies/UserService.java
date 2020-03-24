package com.kamikadze328.testforcv.test2.servicies;

import com.kamikadze328.testforcv.test2.model.User;

public interface UserService {

    User save(User user);

    User findByUsername(String username);


}

