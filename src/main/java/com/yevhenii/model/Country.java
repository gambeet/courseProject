package com.yevhenii.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Entity
public class Country {
    private int id;
    private String name;
    private Collection<Agent> agentsById;
    private Collection<RecruitedStaff> recruitedStaffsById;
    private Collection<StolenDocument> stolenDocumentsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<Agent> getAgentsById() {
        return agentsById;
    }

    public void setAgentsById(Collection<Agent> agentsById) {
        this.agentsById = agentsById;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<RecruitedStaff> getRecruitedStaffsById() {
        return recruitedStaffsById;
    }

    public void setRecruitedStaffsById(Collection<RecruitedStaff> recruitedStaffsById) {
        this.recruitedStaffsById = recruitedStaffsById;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<StolenDocument> getStolenDocumentsById() {
        return stolenDocumentsById;
    }

    public void setStolenDocumentsById(Collection<StolenDocument> stolenDocumentsById) {
        this.stolenDocumentsById = stolenDocumentsById;
    }
}
