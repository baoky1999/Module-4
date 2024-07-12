package com.conversion.dictionary.repository.iml;

import com.conversion.dictionary.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {

    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("spring", "mùa xuân");
        dictionary.put("java", "ngôn ngữ lập trình Java");
    }


    @Override
    public Map<String, String> findAll() {
        return dictionary;
    }

    @Override
    public String findMeaning(String word) {
        if (dictionary.containsKey(word)) {
            String value = dictionary.get(word);
            return value;
        }
        return null;
    }
}
