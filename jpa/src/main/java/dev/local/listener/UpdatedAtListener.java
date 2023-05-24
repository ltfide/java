package dev.local.listener;

import dev.local.entities.UpdatedAtAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class UpdatedAtListener {

    @PrePersist
    @PreUpdate
    public void setLastUpdatedAt(UpdatedAtAware object) {
        object.setUpdatedAt(LocalDateTime.now());
    }
}
