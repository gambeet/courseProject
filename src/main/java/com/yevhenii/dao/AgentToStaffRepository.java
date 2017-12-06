package com.yevhenii.dao;

import com.yevhenii.model.Agent;
import com.yevhenii.model.AgentToStaff;
import com.yevhenii.model.RecruitedStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Repository
public interface AgentToStaffRepository extends CrudRepository<AgentToStaff, Integer>{
//    List<RecruitedStaff> findAllByAgentByAgentId(Agent agent);
}
