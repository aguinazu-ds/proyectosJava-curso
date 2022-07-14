package cl.ejerciciojava.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.ejerciciojava.dojoninja.models.Dojo;
import cl.ejerciciojava.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

    public Dojo updateDojo(Long id, String name) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            Dojo dojo = optionalDojo.get();
            dojo.setId(id);
            dojo.setName(name);
            return dojoRepository.save(dojo);
        } else {
            return null;
        }
    }

    public void deleteDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            dojoRepository.deleteById(id);
        } else {
            System.out.println("El dojo no existe");
        }
    }
}