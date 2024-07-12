package com.conversion.dictionary.repository;

import java.util.Map;

public interface IDictionaryRepository {
    Map<String, String> findAll();

    String findMeaning(String word);
}
