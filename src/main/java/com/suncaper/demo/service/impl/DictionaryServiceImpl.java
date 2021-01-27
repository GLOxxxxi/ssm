package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.Dictionary;
import com.suncaper.demo.entity.DictionaryExample;
import com.suncaper.demo.mapper.DictionaryMapper;
import com.suncaper.demo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Override
    public String getNameByTypeAndValue(String type, String value) {
        DictionaryExample dictionaryExample = new DictionaryExample();
        dictionaryExample.createCriteria().andTypeEqualTo(type).andItemValueEqualTo(value);
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(dictionaryExample);
        return dictionaries.size()>0?dictionaries.get(0).getItemName():null;
    }

    @Override
    public List<Dictionary> getDictionary(Dictionary dictionary) {
        DictionaryExample dictionaryExample = new DictionaryExample();
        dictionaryExample.createCriteria().andTypeEqualTo(dictionary.getType()).andItemValueIsNotNull();
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(dictionaryExample);
        return dictionaries;
    }
}
