package cz.upce.fei.NNPIA_CV01.repository;

import cz.upce.fei.NNPIA_CV01.domain.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}
