package de.luvfist.api.persistence

import de.luvfist.api.persistence.service.TodoService
import de.luvfist.api.web.form.TodoForm
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class InitDataLoader(val todoService: TodoService) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        this.todoService.create(TodoForm(text = "TODO 1"))
        this.todoService.create(TodoForm(text = "TODO 2"))
        this.todoService.create(TodoForm(text = "TODO 3"))
    }
}
