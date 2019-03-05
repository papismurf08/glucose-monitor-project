package com.example.glucosemonitor.data;

import com.example.glucosemonitor.models.ChartData;
import com.example.glucosemonitor.models.ChartData.DataPointModel;

import java.util.List;

public class ChartDaoImpl implements ChartDao {

    @Override
    public List<List<DataPointModel>> getChartData() {
        return ChartData.getDataList();
    }

}