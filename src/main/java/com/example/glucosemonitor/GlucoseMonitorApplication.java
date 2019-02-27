package com.example.glucosemonitor;

import com.example.glucosemonitor.data.LoggyRepository;
import com.example.glucosemonitor.models.Loggy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.glucosemonitor.models.Loggy.Type;

@SpringBootApplication
public class GlucoseMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlucoseMonitorApplication.class, args);
	}

	@Bean
    public CommandLineRunner dataLoader(LoggyRepository repo) {
	    return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Loggy("GLUC", "Glucose", Type.GLUCOSE));
                repo.save(new Loggy("INSU", "Insulin", Type.GLUCOSE));
                repo.save(new Loggy("CARA", "Carbohydrates", Type.GLUCOSE));
                repo.save(new Loggy("TODA", "Time of Day", Type.GLUCOSE));
                repo.save(new Loggy("DATA", "Date & Time", Type.GLUCOSE));
                repo.save(new Loggy("NOTA", "Note", Type.GLUCOSE));

                repo.save(new Loggy("CARB", "Carbohydrates", Type.CARBS));
                repo.save(new Loggy("TODB", "Time of Day", Type.CARBS));
                repo.save(new Loggy("DATB", "Date & Time", Type.CARBS));
                repo.save(new Loggy("NOTB", "Note", Type.CARBS));

                repo.save(new Loggy("MEDI", "Medication", Type.MEDICATION));
                repo.save(new Loggy("TODC", "Time of Day", Type.MEDICATION));
                repo.save(new Loggy("DATC", "Date & Time", Type.MEDICATION));
                repo.save(new Loggy("NOTC", "Note", Type.MEDICATION));

                repo.save(new Loggy("INSN", "Insulin", Type.INSULIN));
                repo.save(new Loggy("TODD", "Time of Day", Type.INSULIN));
                repo.save(new Loggy("DATD", "Date & Time", Type.INSULIN));
                repo.save(new Loggy("NOTD", "Note", Type.INSULIN));

                repo.save(new Loggy("ALCA", "A1C", Type.A1C));
                repo.save(new Loggy("TODE", "Time of Day", Type.A1C));
                repo.save(new Loggy("DATE", "Date & Time", Type.A1C));
                repo.save(new Loggy("NOTE", "Note", Type.A1C));

                repo.save(new Loggy("SYST", "Systolic", Type.BLOODPRESSURE));
                repo.save(new Loggy("DIAS", "Diastolic", Type.BLOODPRESSURE));
                repo.save(new Loggy("HERT", "Heart Rate", Type.BLOODPRESSURE));
                repo.save(new Loggy("TODF", "Time of Day", Type.BLOODPRESSURE));
                repo.save(new Loggy("DATF", "Date & Time", Type.BLOODPRESSURE));
                repo.save(new Loggy("NOTF", "Note", Type.BLOODPRESSURE));

                repo.save(new Loggy("CARC", "Carbohydrates", Type.CARBS));
                repo.save(new Loggy("TODG", "Time of Day", Type.CARBS));
                repo.save(new Loggy("DATG", "Date & Time", Type.CARBS));
                repo.save(new Loggy("NOTG", "Note", Type.CARBS));

                repo.save(new Loggy("KETO", "Ketones", Type.KETONES));
                repo.save(new Loggy("TODH", "Time of Day", Type.KETONES));
                repo.save(new Loggy("DATH", "Date & Time", Type.KETONES));
                repo.save(new Loggy("NOTH", "Note", Type.KETONES));
            }
        };
    }

}

