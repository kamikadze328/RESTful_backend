package com.kamikadze328.testforcv.test2.repositories;

import com.kamikadze328.testforcv.test2.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
