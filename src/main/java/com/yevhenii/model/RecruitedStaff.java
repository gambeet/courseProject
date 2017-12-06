package com.yevhenii.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.sql.Date;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Entity
@Table(name = "recruited_staff", schema = "espionageAgency", catalog = "")
public class RecruitedStaff {
    private int id;
    private Date date;
    private String name;
    private String sex;
    private Collection<AgentToStaff> agentToStaffsById;
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
    @Column(name = "birth_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "full_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecruitedStaff that = (RecruitedStaff) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "recruitedStaffByStaffId")
    public Collection<AgentToStaff> getAgentToStaffsById() {
        return agentToStaffsById;
    }

    public void setAgentToStaffsById(Collection<AgentToStaff> agentToStaffsById) {
        this.agentToStaffsById = agentToStaffsById;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
