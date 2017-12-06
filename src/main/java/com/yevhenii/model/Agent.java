package com.yevhenii.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Entity
public class Agent {
    private int id;
    private String codeName;
    private String password;
    private String role;
    private Boolean status;
    private Country countryByCountryId;
    private Collection<AgentToStaff> agentToStaffsById;
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
    @Column(name = "code_name", unique = true)
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agent agent = (Agent) o;

        if (id != agent.id) return false;
        if (codeName != null ? !codeName.equals(agent.codeName) : agent.codeName != null) return false;
        if (password != null ? !password.equals(agent.password) : agent.password != null) return false;
        if (role != null ? !role.equals(agent.role) : agent.role != null) return false;
        if (status != null ? !status.equals(agent.status) : agent.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @OneToMany(mappedBy = "agentByAgentId")
    public Collection<AgentToStaff> getAgentToStaffsById() {
        return agentToStaffsById;
    }

    public void setAgentToStaffsById(Collection<AgentToStaff> agentToStaffsById) {
        this.agentToStaffsById = agentToStaffsById;
    }

    @OneToMany(mappedBy = "agentByAgentId")
    public Collection<StolenDocument> getStolenDocumentsById() {
        return stolenDocumentsById;
    }

    public void setStolenDocumentsById(Collection<StolenDocument> stolenDocumentsById) {
        this.stolenDocumentsById = stolenDocumentsById;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", codeName='" + codeName + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", country=" + countryByCountryId.getName() +
                '}';
    }
}
