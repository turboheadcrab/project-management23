package com.jrp.pma.dao;

import com.jrp.pma.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
