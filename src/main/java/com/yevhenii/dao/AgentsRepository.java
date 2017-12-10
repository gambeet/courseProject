package com.yevhenii.dao;

import com.yevhenii.model.Agent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Repository
public interface AgentsRepository extends CrudRepository<Agent, Integer> {
    Agent findByCodeName(String codeName);

    @Query(nativeQuery = true,value = "select `espionageagency`.`agent`.`id` AS `id`,`espionageagency`.`agent`.`code_name` AS `code_name`,`espionageagency`.`agent`.`password` AS `password`,`espionageagency`.`agent`.`role` AS `role`,`espionageagency`.`agent`.`status` AS `status`,`espionageagency`.`agent`.`country_id` AS `country_id` from (`espionageagency`.`agent` left join `espionageagency`.`stolen_document` on((`espionageagency`.`agent`.`id` = `espionageagency`.`stolen_document`.`agent_id`))) group by `espionageagency`.`agent`.`id` order by count(`espionageagency`.`stolen_document`.`agent_id`) desc limit 10")
    List<Agent> findTop10Agents();
}
