package com.conversion.sandwichcondiments.repository.iml;

import com.conversion.sandwichcondiments.model.Sandwich;
import com.conversion.sandwichcondiments.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SandwichRepository implements ISandwichRepository {

    private static final List<Sandwich> item = new ArrayList<>();

    static {
        item.add(new Sandwich("Rau xà lách"));
        item.add(new Sandwich("Cà chua"));
        item.add(new Sandwich("Mù tạc"));
        item.add(new Sandwich("Giá đỗ"));
    }


    @Override
    public List<Sandwich> getAll() {
        return item;
    }
}
