package com.yevhenii.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Yevhenii on 26.11.2017.
 */
@Entity
@Table(name = "recruited_staff", schema = "espionageAgency", catalog = "")
public class RecruitedStaff {
    private int id;
    private Date birthDate;
    private String fullName;
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
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
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
