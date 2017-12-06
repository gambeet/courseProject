package com.yevhenii.dao;

import com.yevhenii.model.RecruitedStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Repository
public interface RecruitedStaffRepository extends CrudRepository<RecruitedStaff, Integer> {

//    public RecruitedStaff findByAgentToStaffsById(int id);
}
