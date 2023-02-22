package cz.upce.fei.NNPIA_CV01.domain;

import javax.persistence.*;

@Entity
public class AppUserRole {
    @OneToOne
    @JoinColumn(name = "userID")
    private AppUser userID;
    @OneToOne
    @JoinColumn(name = "roleID")
    private Role roleID;
}

