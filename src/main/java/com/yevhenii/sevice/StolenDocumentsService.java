package com.yevhenii.sevice;

import com.yevhenii.dao.AgentsRepository;
import com.yevhenii.dao.StolenDocumentsRepository;
import com.yevhenii.model.StolenDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Service
public class StolenDocumentsService {
    @Autowired
    private StolenDocumentsRepository repository;

    public void save(StolenDocument item) {
        repository.save(item);
    }

    public List<StolenDocument> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }

    public void delete(int id){
        repository.delete(id);
    }

    public void update(StolenDocument item){
        repository.save(item);
    }

    public StolenDocument getById(int id){
        return repository.findOne(id);
    }
}
