package cl.ejerciciojava.lenguaje.services;

import cl.ejerciciojava.lenguaje.models.Language;
import cl.ejerciciojava.lenguaje.repositories.LanguageRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languagesRepository) {
        this.languageRepository = languagesRepository;
    }

    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }

    public Language findLanguage(Long id) {
        Optional<Language> optionallanguage = languageRepository.findById(id);
        if (optionallanguage.isPresent()) {
            return optionallanguage.get();
        } else {
            return null;
        }
    }

    public Language updateLanguage(Long id, String name, String creator, String version) {
        Optional<Language> optionallanguage = languageRepository.findById(id);
        if (optionallanguage.isPresent()) {
            Language language = optionallanguage.get();
            language.setId(id);
            language.setName(name);
            language.setCreator(creator);
            language.setVersion(version);
            return languageRepository.save(language);
        } else {
            return null;
        }
    }

    public void deleteLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            languageRepository.deleteById(id);
        } else {
            System.out.println("El lenguaje de programación buscado no existe.");
        }
    }

}
