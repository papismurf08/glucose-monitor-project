package com.example.glucosemonitor.data;

//CanvasjsChartDao.java
//package com.canvasjs.chart.daos;

import java.util.List;

//import com.example.glucosemonitor.models.ChartData;
import com.example.glucosemonitor.models.ChartData.DataPointModel;

public interface ChartDao {

    List<List<DataPointModel>> getChartData();

}

/*package com.example.glucosemonitor.data;

import java.util.List;

import com.example.glucosemonitor.models.ChartData;
import com.example.glucosemonitor.models.ChartData.DataPointModel;*//*


public class ChartDaoImpl implements ChartDao {

    @Override
    public List<List<DataPointModel>> getChartData() {
        return ChartData.getDataList();
    }

}*/
