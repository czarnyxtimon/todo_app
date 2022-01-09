package io.github.czarnyxtimon.controller;

import io.github.czarnyxtimon.model.Task;
import io.github.czarnyxtimon.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST,path ="/tasks")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task toCreate) {
        Task result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/tasks")
    ResponseEntity<Task> readAllTasks(@RequestBody @Valid Task toCreate) {
        Task result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/tasks", params = {"!sort","!page","!size"})
    ResponseEntity<List<Task>> readAllTasks(){
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository. findAll());
    }

    @RequestMapping(method = RequestMethod.GET,path ="/tasks/{id}")
    ResponseEntity<Task> readTask(@PathVariable int id){
        return repository.findById(id)
                .map(ResponseEntity::ok) //zapis method reference a pod spodem wersja lambda
                .orElse(ResponseEntity.notFound().build());
//        return repository.findById(id).map(task -> ResponseEntity.ok(task))
//                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.PUT,path ="/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

}
