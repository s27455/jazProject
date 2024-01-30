package com.module.springboot.jazApp.service.implementation;


import com.module.springboot.jazApp.entity.Rents;
import com.module.springboot.jazApp.repository.RentsRepository;
import com.module.springboot.jazApp.service.RentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RentsServiceImpl implements RentsService {


    private RentsRepository rentsRepository;

    @Autowired
    public RentsServiceImpl(RentsRepository theRentsRepository) {
        rentsRepository = theRentsRepository;
    }

    @Override
    public List<Rents> findAll() {
        return rentsRepository.findAll();
    }

    @Override
    public Rents findById(int theId) {
        Optional<Rents> result = rentsRepository.findById(theId);

        Rents theRents = null;

        if (result.isPresent()) {
            theRents = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theRents;
        }

    @Override
    public Rents save(Rents theRents) {
        return rentsRepository.save(theRents);
    }

    @Override
    public void deleteById(int theId) {
        rentsRepository.deleteById(theId);
    }
}






