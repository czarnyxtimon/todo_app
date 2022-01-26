package io.github.czarnyxtimon.logic;

import io.github.czarnyxtimon.TaskConfigurationProperties;
import io.github.czarnyxtimon.model.ProjectRepository;
import io.github.czarnyxtimon.model.TaskGroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LogicConfiguration {
    @Bean
    ProjectService service(
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskConfigurationProperties config
    ) {
        return new ProjectService(repository, taskGroupRepository, config);
    }
}
