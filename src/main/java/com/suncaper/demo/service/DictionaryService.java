package com.suncaper.demo.service;

import com.suncaper.demo.entity.Dictionary;

import java.util.List;

public interface DictionaryService {
    String getNameByTypeAndValue(String type,String value);


    List<Dictionary> getDictionary(Dictionary dictionary);
}
