package com.example.demo.loader;

import com.example.demo.entity.MovieAwardEntity;
import com.example.demo.repository.MovieAwardRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvDatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private MovieAwardRepository movieAwardRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }
        processCsvAndSave("/database/movielist.csv");
        alreadySetup = true;
    }

    public void processCsvAndSave(String csvFilePath) {
        try (InputStream in = getClass().getResourceAsStream(csvFilePath);
             Reader reader = new InputStreamReader(in);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                     .withDelimiter(';'))) {

            List<MovieAwardEntity> movies = new ArrayList<>();

            for (CSVRecord record : csvParser) {
                MovieAwardEntity movie = new MovieAwardEntity();

                movie.setYear(Integer.parseInt(record.get("year")));
                movie.setTitle(record.get("title"));
                movie.setStudios(record.get("studios"));
                movie.setProducers(record.get("producers"));
                movie.setWinner(parseWinner(record.get("winner")));

                movies.add(movie);
            }

            movieAwardRepository.saveAll(movies);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean parseWinner(String winner) {
        return "yes".equalsIgnoreCase(winner.trim());
    }
}