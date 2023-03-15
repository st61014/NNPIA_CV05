package cz.upce.fei.NNPIA_CV05;

import cz.upce.fei.NNPIA_CV05.domain.AppUser;

import java.time.LocalDateTime;

public final class Example {
    public static AppUser EXISTING_USER = new AppUser(100L, "test1", "1234", true, LocalDateTime.now(), LocalDateTime.now());
    private Example(){}
}
