package de.luvfist.api.web.controller

import de.luvfist.api.persistence.service.TodoService
import de.luvfist.api.web.form.TodoForm
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(val todoService: TodoService) {

    @GetMapping
    fun findAll() = this.todoService.findAll()

    @GetMapping("/{id}")
    fun findOneById(@PathVariable id: Int) = this.todoService.findOneById(id)

    @PostMapping
    fun create(form: TodoForm) = this.todoService.create(form)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody form: TodoForm) = this.todoService.update(id, form)

    @GetMapping("/{id}/toggle")
    fun toggle(@PathVariable id: Int) = this.todoService.toggle(id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = this.todoService.delete(id)
}
