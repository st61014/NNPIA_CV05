package cz.upce.fei.NNPIA_CV04.service;

import cz.upce.fei.NNPIA_CV04.domain.Task;
import cz.upce.fei.NNPIA_CV04.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAllByAppUserId(final Long appUserId) {
        return taskRepository.findAllByAuthorId(appUserId);
    }
}
