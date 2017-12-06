package com.yevhenii.sevice;

import com.yevhenii.dao.RecruitedStaffRepository;
import com.yevhenii.dao.StolenDocumentsRepository;
import com.yevhenii.model.AgentToStaff;
import com.yevhenii.model.RecruitedStaff;
import com.yevhenii.model.StolenDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Service
public class RecruitedStaffService {
    @Autowired
    private RecruitedStaffRepository repository;

    public void save(RecruitedStaff item) {
        repository.save(item);
    }

    public List<RecruitedStaff> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }

    public void delete(int id){
        repository.delete(id);
    }

    public void update(RecruitedStaff item){
        repository.save(item);
    }

    public RecruitedStaff getById(int id){
        return repository.findOne(id);
    }

//    public List<RecruitedStaff> getByAgentId(List<AgentToStaff> asList){
//        List<RecruitedStaff> list = new ArrayList<>();
//        asList.forEach(item ->{
//            list.add(repository.findByAgentToStaffsById(item.getId()));
//        });
//        return list;
//        //return repository.findAllByAgentToStaffsByIdContains(id);
//        }
}
