package com.kamikadze328.testforcv.test2.repositories;

import com.kamikadze328.testforcv.test2.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
public interface RoomRepository extends CrudRepository<Room, Long> {
}
