package io.github.czarnyxtimon.adapter;

import io.github.czarnyxtimon.model.TaskGroup;
import io.github.czarnyxtimon.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {
}
