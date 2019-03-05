package com.example.glucosemonitor.services;

import com.example.glucosemonitor.data.ChartDao;
import com.example.glucosemonitor.models.ChartData.DataPointModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChartServiceImpl implements ChartService {

    @Autowired
    private ChartDao chartDao;

    public void setChartDao(ChartDao chartDao) {
        this.chartDao = chartDao;
    }

    @Override
    public List<List<DataPointModel>> getChartData() {
        return chartDao.getChartData();
    }

}
