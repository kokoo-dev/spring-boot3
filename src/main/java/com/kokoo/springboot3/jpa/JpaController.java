package com.kokoo.springboot3.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
@RequiredArgsConstructor
public class JpaController {

    private final JpaSampleRepository jpaSampleRepository;
    private final JpaSampleRepositoryImpl jpaSampleRepositoryImpl;

    @PostMapping("")
    public Long setJpa() {
        JpaSample savedJpaSample = jpaSampleRepository.save(new JpaSample());

        return savedJpaSample.getId();
    }

    @GetMapping("")
    public List<JpaSample> getJpa() {
        return jpaSampleRepository.findAll();
    }

    @GetMapping("/{name}")
    public long getCountByName(@PathVariable String name) {
        return jpaSampleRepositoryImpl.countByName(name);
    }
}
