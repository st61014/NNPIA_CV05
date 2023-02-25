package cz.upce.fei.NNPIA_CV01.domain;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    private Long taskID;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDateTime creation_date;
    @Column
    private LocalDateTime update_date;
    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    @ToString.Exclude
    private AppUser author;
}
