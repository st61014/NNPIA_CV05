package cz.upce.fei.NNPIA_CV01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class AppUser {
    @Id
    private int userID;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean active;
    @Column
    private LocalDateTime creation_date;
    @Column
    private LocalDateTime update_date;
}
