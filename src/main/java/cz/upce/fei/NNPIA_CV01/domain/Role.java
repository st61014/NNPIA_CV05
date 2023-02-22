package cz.upce.fei.NNPIA_CV01.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    private int roleID;
    @Column
    private String name;
}
