package cl.codingdojo.bootcampestudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.codingdojo.bootcampestudiantes.models.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findAll();

    Region findRegionById(Integer id);

}
