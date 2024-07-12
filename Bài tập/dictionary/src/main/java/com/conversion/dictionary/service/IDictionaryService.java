package com.conversion.dictionary.service;

import java.util.Map;

public interface IDictionaryService {
    Map<String, String> findAll();

    String findMeaning(String word);
}
