package com.yevhenii.sevice;

import com.yevhenii.dao.CountriesRepository;
import com.yevhenii.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountriesService {
    @Autowired
    private CountriesRepository repository;

    public void save(Country item) {
        repository.save(item);
    }

    public List<Country> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }

    public void delete(int id){
        repository.delete(id);
    }

    public void update(Country item){
        repository.save(item);
    }

    public Country getById(int id){
        return repository.findOne(id);
    }
}
