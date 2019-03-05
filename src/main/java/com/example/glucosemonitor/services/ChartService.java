package com.example.glucosemonitor.services;

import java.util.List;

import com.example.glucosemonitor.models.ChartData;
import com.example.glucosemonitor.models.ChartData.DataPointModel;
import com.example.glucosemonitor.data.ChartDao;

import org.springframework.beans.factory.annotation.Autowired;

public interface ChartService {

    List<List<DataPointModel>> getChartData();

}




