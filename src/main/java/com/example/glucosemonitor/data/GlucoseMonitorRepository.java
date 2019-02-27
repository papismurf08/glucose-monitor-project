package com.example.glucosemonitor.data;

import com.example.glucosemonitor.models.GlucoseMonitor;
import org.springframework.data.repository.CrudRepository;

public interface GlucoseMonitorRepository extends CrudRepository<GlucoseMonitor, Integer> { }
