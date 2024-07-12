package com.conversion.dictionary.service.iml;

import com.conversion.dictionary.repository.IDictionaryRepository;
import com.conversion.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public Map<String, String> findAll() {
        return dictionaryRepository.findAll();
    }

    @Override
    public String findMeaning(String word) {
        return dictionaryRepository.findMeaning(word);
    }
}
