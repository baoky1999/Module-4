package com.conversion.sandwichcondiments.repository;

import com.conversion.sandwichcondiments.model.Sandwich;

import java.util.List;

public interface ISandwichRepository {
    List<Sandwich> getAll();
}
