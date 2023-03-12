package cz.upce.fei.NNPIA_CV04.repository;

import cz.upce.fei.NNPIA_CV04.domain.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    List<Task> findAllByAuthorId(final Long id);
}
