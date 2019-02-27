package com.example.glucosemonitor.models;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.glucosemonitor.models.Loggy;
import com.example.glucosemonitor.data.LoggyRepository;

@Component
public class LoggyByIdConverter implements Converter<String, Loggy> {

    private LoggyRepository loggyRepo;

    @Autowired
    public LoggyByIdConverter(LoggyRepository loggyRepo) {
        this.loggyRepo = loggyRepo;
    }

    @Override
    public Loggy convert(String id) {
        Optional<Loggy> optionalLoggy = loggyRepo.findById(id);
        return optionalLoggy.isPresent() ?
                optionalLoggy.get() : null;
    }

}