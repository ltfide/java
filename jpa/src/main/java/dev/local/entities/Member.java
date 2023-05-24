package dev.local.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private Name name;

    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(
            name = "member_id", referencedColumnName = "id"
    ))
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, Integer> skills;

    @ElementCollection
    @CollectionTable(name = "hobbies", joinColumns = @JoinColumn(
            name = "member_id", referencedColumnName = "id"
    ))
    private List<String> hobbies;

    private String email;

    @Transient
    private String fullName;

    @PostLoad
    public void postLoad() {
        fullName = String.format("%s. %s %s",
                name.getTitle(),
                name.getFirstName(),
                name.getLastName());
    }
}
