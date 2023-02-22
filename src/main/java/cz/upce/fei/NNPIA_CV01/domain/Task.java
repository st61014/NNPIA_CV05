package cz.upce.fei.NNPIA_CV01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    private int taskID;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDateTime creation_date;
    @Column
    private LocalDateTime update_date;
    @Column
    private int author_id;
}
