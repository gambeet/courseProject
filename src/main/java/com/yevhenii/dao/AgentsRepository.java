package com.yevhenii.dao;

import com.yevhenii.model.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Repository
public interface AgentsRepository extends CrudRepository<Agent, Integer> {

    //@Transactional
    //@Query(value = "select a from Agent a where a.codeName = ?1")
    Agent findByCodeName(String codeName);
}
