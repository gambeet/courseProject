package com.yevhenii.dao;

import com.yevhenii.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository <Country, Integer> {
    @Modifying
    @Query("UPDATE Country c SET c.name = :name WHERE c.id = :countryId")
    int update(@Param("countryId") int countryId, @Param("name") String name);
}
