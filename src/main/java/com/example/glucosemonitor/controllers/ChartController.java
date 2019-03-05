package com.example.glucosemonitor.controllers;

//CanvasjsChartController.java
//package com.canvasjs.chart.controllers;

import java.util.List;

import com.example.glucosemonitor.data.ChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.glucosemonitor.models.ChartData.DataPointModel;
import com.example.glucosemonitor.models.ChartData.DatabaseConnectionException;
import com.example.glucosemonitor.services.ChartService;

@Controller
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ChartDao chartDao;

    @Autowired
    private ChartService chartService;

    @GetMapping
    public String springMVC(ModelMap modelMap) {
        List<List<DataPointModel>> dataList = chartService.getChartData();
        modelMap.addAttribute("dataPointsList", dataList);
        return "chart";
    }

    @ExceptionHandler({DatabaseConnectionException.class})
    public ModelAndView getSuperheroesUnavailable(DatabaseConnectionException ex) {
        return new ModelAndView("chart", "error", ex.getMessage());
    }
}