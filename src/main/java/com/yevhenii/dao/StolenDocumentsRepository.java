package com.yevhenii.dao;

import com.yevhenii.model.StolenDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Repository
public interface StolenDocumentsRepository extends CrudRepository<StolenDocument, Integer> {

//    public List<StolenDocument> findStolenDocumentsByAgentByAgentId(int id);
}
