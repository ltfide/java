package dev.local.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class DepartmentId implements Serializable {

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "company_id")
    private String companyId;
}
