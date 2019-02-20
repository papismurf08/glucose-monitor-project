package com.example.glucosemonitor.models;

import java.util.ArrayList;

public class GlucoseMonitorData {

    static ArrayList<GlucoseMonitor> gmdata = new ArrayList<>();
    //need to implement database, leaving as is

    public static ArrayList<GlucoseMonitor> getAll() {
        return gmdata;
    }

    public static void add(GlucoseMonitor newGlucoseMonitor) {
        gmdata.add(newGlucoseMonitor);
    }

    public static void remove(int id) {
        GlucoseMonitor GlucoseMonitorToRemove = getById(id);
        gmdata.remove(GlucoseMonitorToRemove);
    }
    public static GlucoseMonitor getById(int id) {

        GlucoseMonitor theGlucoseMonitor = null;

        for (GlucoseMonitor candidateGlucoseMonitor : gmdata) {
            if (candidateGlucoseMonitor.getGlucoseMonitorId() == id) {
                theGlucoseMonitor = candidateGlucoseMonitor;
            }
        }
        return theGlucoseMonitor;
    }

}
