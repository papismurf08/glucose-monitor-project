package com.example.glucosemonitor.data;

import org.springframework.data.repository.CrudRepository;
import com.example.glucosemonitor.models.Loggy;

public interface LoggyRepository extends CrudRepository<Loggy, String> {
}
