package com.example.glucosemonitor.models;

import java.util.ArrayList;

public class GMData {

    static ArrayList<GlucoseMonitor> cheeses = new ArrayList<>();
    /*We will learn about Static classes but as of now note that this isn't a substitute
    for a database because this ArrayList lives in memory and once session is closed
    it will be erased*/

    public static ArrayList<GlucoseMonitor> getAll() {
        return cheeses;
    }

    public static void add(GlucoseMonitor newCheese) {
        cheeses.add(newCheese);
    }

    public static GlucoseMonitor getById(int id) {

        GlucoseMonitor theCheese = null;

        for (GlucoseMonitor candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }
        return theCheese;
    }

    public static void remove(int id) {
        GlucoseMonitor cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }
}
