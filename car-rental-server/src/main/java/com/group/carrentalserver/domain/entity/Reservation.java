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
@Table(name = "reservations")
public class Reservation extends BaseEntity {

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime dueDate;

    @ManyToOne
    private Car car;

    @ManyToOne
    private User user;

    public Reservation() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreationDate(), getDueDate());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Reservation)) {
            return false;
        }
        return this.getId().equals(((Reservation) o).getId());
    }
}
