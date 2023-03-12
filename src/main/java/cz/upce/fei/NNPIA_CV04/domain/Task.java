package cz.upce.fei.NNPIA_CV04.domain;

import cz.upce.fei.NNPIA_CV04.dto.TaskDtoV1;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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
    public TaskDtoV1 toDto() {
        return new TaskDtoV1(
                getTaskID(),
                getTitle(),
                getDescription(),
                getCreation_date(),
                getUpdate_date()
        );
    }
}
