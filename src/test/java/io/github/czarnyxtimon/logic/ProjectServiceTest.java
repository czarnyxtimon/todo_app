package io.github.czarnyxtimon.logic;

import io.github.czarnyxtimon.model.TaskGroup;
import io.github.czarnyxtimon.model.TaskGroupRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    @Test
    @DisplayName("should throw IllegalStateException when configured to allow just 1 group and the other undone group exists")
    void createGroup_noMultipleGroupsConfig_And_undoneGroupExists_throwsIllegalStateException() {
        // given
        var mockGroupRepository = new TaskGroupRepository() {
            @Override
            public List<TaskGroup> findAll() {
                return null;
            }

            @Override
            public Optional<TaskGroup> findById(final Integer id) {
                return Optional.empty();
            }

            @Override
            public TaskGroup save(final TaskGroup entity) {
                return null;
            }

            @Override
            public boolean existsByDoneIsFalseAndProject_Id(final Integer projectId) {
                return false;
            }
        };
        // when
        // then
    }
}