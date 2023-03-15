package cz.upce.fei.NNPIA_CV05.domain;

import cz.upce.fei.NNPIA_CV05.dto.AppUserResponseDtoV1;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
    @EqualsAndHashCode.Exclude
    private List<Task> tasks = Collections.emptyList();
    @ManyToMany(mappedBy = "users")
    @EqualsAndHashCode.Exclude
    private List<Role> roles = Collections.emptyList();
    public AppUser(Long id, String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.userID = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creation_date = creationDate;
        this.update_date = updateDate;
    }

    public AppUser(String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creation_date = creationDate;
        this.update_date = updateDate;
    }

    public AppUserResponseDtoV1 toDto() {
        return new AppUserResponseDtoV1(
                getUserID(),
                getUsername(),
                getPassword(),
                getActive(),
                getCreation_date(),
                getUpdate_date(),
                getRoles()
        );
    }
}
