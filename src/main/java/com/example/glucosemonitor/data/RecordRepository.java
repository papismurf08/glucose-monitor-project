package com.example.glucosemonitor.data;

import com.example.glucosemonitor.models.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long> {
}
