package com.yevhenii.sevice;

import com.yevhenii.dao.AgentsRepository;
import com.yevhenii.model.Agent;
import com.yevhenii.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Service
public class AgentsService {

    @Autowired
    private AgentsRepository repository;

    public void save(Agent item) {
        repository.save(item);
    }

    public List<Agent> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }
    public List<Agent> getTop10() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findTop10Agents().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }

    public void delete(int id){
        repository.delete(id);
    }

    public void update(Agent item){
        repository.save(item);
    }

    public Agent getById(int id){
        return repository.findOne(id);
    }

    public Agent getByCodeName(String codeName){
        return repository.findByCodeName(codeName);
    }
}
