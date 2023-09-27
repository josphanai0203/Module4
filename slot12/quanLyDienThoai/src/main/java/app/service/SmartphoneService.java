package app.service;

import app.domain.Smartphone;
import app.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private SmartphoneRepository repository;
    @Override
    public List<Smartphone> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return repository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
