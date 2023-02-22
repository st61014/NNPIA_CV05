package cz.upce.fei.NNPIA_CV01.repository;

import cz.upce.fei.NNPIA_CV01.domain.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {
    List<AppUser> findAllByActiveEquals(Boolean active);
}
