package com.group.carrentalserver.domain.entity;

import com.group.carrentalserver.domain.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "insurances")
public class Insurance extends BaseEntity {

    @Column
    private String company;

    @Column
    private LocalDateTime validFrom;

    @Column
    private LocalDateTime validTo;

    @ManyToOne
    private Car car;

    public Insurance() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompany(), getValidFrom(), getValidTo());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Insurance)) {
            return false;
        }
        return this.getId().equals(((Insurance) o).getId());
    }
}
