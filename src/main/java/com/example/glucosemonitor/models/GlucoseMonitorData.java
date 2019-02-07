package com.example.glucosemonitor.models;

import java.util.ArrayList;

public class GlucoseMonitorData {

    static ArrayList<GlucoseMonitor> gmdata = new ArrayList<>();
    /*We will learn about Static classes but as of now note that this isn't a substitute
    for a database because this ArrayList lives in memory and once session is closed
    it will be erased*/

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
