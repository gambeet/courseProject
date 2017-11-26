package com.yevhenii.model;

import javax.persistence.*;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Entity
@Table(name = "agent_to_staff", schema = "espionageAgency", catalog = "")
public class AgentToStaff {
    private int id;
    private Agent agentByAgentId;
    private RecruitedStaff recruitedStaffByStaffId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentToStaff that = (AgentToStaff) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "id", nullable = false)
    public Agent getAgentByAgentId() {
        return agentByAgentId;
    }

    public void setAgentByAgentId(Agent agentByAgentId) {
        this.agentByAgentId = agentByAgentId;
    }

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = false)
    public RecruitedStaff getRecruitedStaffByStaffId() {
        return recruitedStaffByStaffId;
    }

    public void setRecruitedStaffByStaffId(RecruitedStaff recruitedStaffByStaffId) {
        this.recruitedStaffByStaffId = recruitedStaffByStaffId;
    }
}
