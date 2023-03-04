package cz.upce.fei.NNPIA_CV01.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class AppUser {
    @Id
    private Long userID;
    @Column
    @NotNull
    @NotEmpty
    @Length(min = 1, max = 255)
    private String username;
    @Column
    private String password;
    @Column
    private Boolean active;
    @Column
    private LocalDateTime creation_date;
    @Column
    private LocalDateTime update_date;
    @OneToMany(mappedBy = "author")
    private List<Task> tasks = Collections.emptyList();
    @ManyToMany(mappedBy = "users")
    private List<Role> roles = Collections.emptyList();
}
