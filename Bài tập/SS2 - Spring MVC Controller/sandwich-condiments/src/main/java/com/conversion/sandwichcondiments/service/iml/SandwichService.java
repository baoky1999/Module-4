package com.conversion.sandwichcondiments.service.iml;

import com.conversion.sandwichcondiments.model.Sandwich;
import com.conversion.sandwichcondiments.repository.ISandwichRepository;
import com.conversion.sandwichcondiments.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService implements ISandwichService {

    @Autowired
    private ISandwichRepository sandwichRepository;

    @Override
    public List<Sandwich> getAll() {
        return sandwichRepository.getAll();
    }
}
