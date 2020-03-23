package com.kamikadze328.testforcv.test2.repositories;

import com.kamikadze328.testforcv.test2.model.ContactInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "contactInfo", path = "contactInfo")
public interface StudentInfoRepository extends CrudRepository<ContactInfo, Long> {
}
