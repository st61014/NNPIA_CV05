package cz.upce.fei.NNPIA_CV01.controller;

import cz.upce.fei.NNPIA_CV01.domain.AppUser;
import cz.upce.fei.NNPIA_CV01.repository.AppUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/app-user")
public class AppUserController {
    private final AppUserRepository appUserRepository;

    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("")
    public List<AppUser> findAll(){
        return appUserRepository.findAllByActiveEquals(true);
    }

    @GetMapping("/id")
    public ResponseEntity<AppUser> findUserByID(@RequestParam Long id){
        return appUserRepository.findById(id).map(appUser -> ResponseEntity
                        .ok().body(appUser))
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Object> createNewUser(@RequestBody AppUser appUser){
        appUserRepository.save(appUser);
        return ResponseEntity.ok().build();
    }
    @PutMapping("")
    public ResponseEntity<Object> updateUser(@RequestBody AppUser appUser){
        appUserRepository.updateAppUserById(appUser.getUserID(), appUser.getUsername(), appUser.getPassword(), appUser.getActive() , LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteUser(@RequestParam Long id){
        appUserRepository.findById(id).ifPresent(appUser -> {
            appUserRepository.delete(appUser);
        });
        return ResponseEntity.ok().build();
    }
}
