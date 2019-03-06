package com.example.glucosemonitor.services;

import com.example.glucosemonitor.data.ChartRepository;
import com.example.glucosemonitor.data.CreateRecordRepository;
import com.example.glucosemonitor.models.Chart;
import com.example.glucosemonitor.models.CreateRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("createRecordService")
public class CreateRecordServiceImpl implements CreateRecordService {

    @Autowired
    private CreateRecordRepository createRecordRepository;

    @Override
    public Iterable<CreateRecord> findAll() {
        return createRecordRepository.findAll();
    }
}
