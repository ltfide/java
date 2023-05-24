package dev.local.entities;

import java.time.LocalDateTime;

public interface UpdatedAtAware {
    void setUpdatedAt(LocalDateTime updatedAt);
}
