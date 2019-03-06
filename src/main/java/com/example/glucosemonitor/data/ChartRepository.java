package com.example.glucosemonitor.data;

import com.example.glucosemonitor.models.Chart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("chartRepository") //removes AutoWired error in CreateRecordServiceImpl when you comment this out
public interface ChartRepository extends CrudRepository<Chart, Long> {
}
