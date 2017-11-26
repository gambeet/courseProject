package com.yevhenii.model;

import javax.persistence.*;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Entity
@Table(name = "stolen_document", schema = "espionageAgency", catalog = "")
public class StolenDocument {
    private int id;
    private String name;
    private Agent agentByAgentId;
    private Country countryByCountryId;

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

        StolenDocument that = (StolenDocument) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    public Agent getAgentByAgentId() {
        return agentByAgentId;
    }

    public void setAgentByAgentId(Agent agentByAgentId) {
        this.agentByAgentId = agentByAgentId;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
