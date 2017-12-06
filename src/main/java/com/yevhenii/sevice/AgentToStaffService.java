package com.yevhenii.sevice;

import com.yevhenii.dao.AgentToStaffRepository;
import com.yevhenii.dao.RecruitedStaffRepository;
import com.yevhenii.model.Agent;
import com.yevhenii.model.AgentToStaff;
import com.yevhenii.model.RecruitedStaff;
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
public class AgentToStaffService {
    @Autowired
    private AgentToStaffRepository repository;

    public void save(AgentToStaff item) {
        repository.save(item);
    }

    public List<AgentToStaff> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }

    public void delete(int id){
        repository.delete(id);
    }

    public void update(AgentToStaff item){
        repository.save(item);
    }

    public AgentToStaff getById(int id){
        return repository.findOne(id);
    }

//    public List<RecruitedStaff>getByAgent(Agent agent){return repository.findAllByAgentByAgentId(agent);}
}
