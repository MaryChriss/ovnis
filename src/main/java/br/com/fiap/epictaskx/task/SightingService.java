package br.com.fiap.epictaskx.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightingService {

    private final SightingRepository sightingRepository;

    public SightingService(SightingRepository sightingRepository) {
        this.sightingRepository = sightingRepository;
    }

    public List<Sighting> getAllTasks(){
        return sightingRepository.findAll();
    }

    public Sighting save(Sighting sighting) {
        return sightingRepository.save(sighting);
    }
}
