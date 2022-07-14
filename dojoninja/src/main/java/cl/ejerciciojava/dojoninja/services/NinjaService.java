package cl.ejerciciojava.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.ejerciciojava.dojoninja.models.Ninja;
import cl.ejerciciojava.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }

    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }

    public Ninja updateNinja(Long id, String firstName, String lastName, Integer age) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            Ninja ninja = optionalNinja.get();
            ninja.setFirstName(firstName);
            ninja.setLastName(lastName);
            ninja.setAge(age);
            return ninjaRepository.save(ninja);
        } else {
            return null;
        }
    }

    public void deleteNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            ninjaRepository.deleteById(id);
        } else {
            System.out.println("El ninja no existe");
        }
    }
}
