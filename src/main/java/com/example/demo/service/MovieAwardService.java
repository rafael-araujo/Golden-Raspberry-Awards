package com.example.demo.service;

import com.example.demo.entity.MovieAwardEntity;
import com.example.demo.model.dto.AwardIntervalDTO;
import com.example.demo.model.dto.ProducerIntervalDTO;
import com.example.demo.repository.MovieAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieAwardService {

    @Autowired
    private MovieAwardRepository repository;

    public AwardIntervalDTO calculateAwardIntervals() {
        List<MovieAwardEntity> awards = repository.findByWinnerTrueOrderByYearAsc();
        Map<String, List<Integer>> producerAwardsMap = new HashMap<>();

        for (MovieAwardEntity award : awards) {
            Arrays.stream(award.getProducers().split(",\\s*|\\sand\\s*"))
                    .forEach(producer -> producerAwardsMap.computeIfAbsent(producer, k -> new ArrayList<>()).add(award.getYear()));
        }

        List<ProducerIntervalDTO> minIntervals = new ArrayList<>();
        List<ProducerIntervalDTO> maxIntervals = new ArrayList<>();
        int globalMinInterval = Integer.MAX_VALUE;
        int globalMaxInterval = 0;

        for (Map.Entry<String, List<Integer>> entry : producerAwardsMap.entrySet()) {
            List<Integer> years = entry.getValue();
            Collections.sort(years);

            for (int i = 0; i < years.size() - 1; i++) {
                int interval = years.get(i + 1) - years.get(i);
                if (interval < globalMinInterval) {
                    globalMinInterval = interval;
                    minIntervals.clear();
                    minIntervals.add(new ProducerIntervalDTO(entry.getKey(), interval, years.get(i), years.get(i + 1)));
                } else if (interval == globalMinInterval) {
                    minIntervals.add(new ProducerIntervalDTO(entry.getKey(), interval, years.get(i), years.get(i + 1)));
                }

                if (interval > globalMaxInterval) {
                    globalMaxInterval = interval;
                    maxIntervals.clear();
                    maxIntervals.add(new ProducerIntervalDTO(entry.getKey(), interval, years.get(i), years.get(i + 1)));
                } else if (interval == globalMaxInterval) {
                    maxIntervals.add(new ProducerIntervalDTO(entry.getKey(), interval, years.get(i), years.get(i + 1)));
                }
            }
        }

        return new AwardIntervalDTO(minIntervals, maxIntervals);
    }
}