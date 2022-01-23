package io.github.czarnyxtimon.logic;

import io.github.czarnyxtimon.model.Task;
import io.github.czarnyxtimon.model.TaskGroup;
import io.github.czarnyxtimon.model.TaskGroupRepository;
import io.github.czarnyxtimon.model.projection.GroupReadModel;
import io.github.czarnyxtimon.model.projection.GroupWriteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {
    private TaskGroupRepository repository;

    TaskGroupService(final TaskGroupRepository repository) {
        this.repository = repository;
    }

    public GroupReadModel createGroup(GroupWriteModel source) {
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }
}
