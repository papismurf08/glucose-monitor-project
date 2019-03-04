package com.example.glucosemonitor.data;

import com.example.glucosemonitor.models.CreateRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface CreateRecordRepository extends CrudRepository<CreateRecord, Long> {
}
