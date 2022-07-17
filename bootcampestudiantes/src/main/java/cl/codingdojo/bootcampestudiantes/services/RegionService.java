package cl.codingdojo.bootcampestudiantes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.codingdojo.bootcampestudiantes.models.Region;
import cl.codingdojo.bootcampestudiantes.repositories.RegionRepository;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> allRegiones() {
        return regionRepository.findAll();
    }

    public Region findRegion(Integer Id) {
        return regionRepository.findRegionById(Id);
    }
}
