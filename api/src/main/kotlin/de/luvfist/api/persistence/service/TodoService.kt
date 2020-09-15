package de.luvfist.api.persistence.service

import de.luvfist.api.persistence.model.Todo
import de.luvfist.api.persistence.repository.TodoRepository
import de.luvfist.api.web.form.TodoForm
import org.springframework.stereotype.Service

@Service
class TodoService(val todoRepository: TodoRepository) {

    fun findAll(): List<Todo> = this.todoRepository.findAll()

    fun findOneById(id: Int): Todo {
        val optional = this.todoRepository.findById(id)

        if (optional.isEmpty) throw TodoNotFoundException("There is no todo with id: $id")

        return optional.get()
    }

    fun create(form: TodoForm): Todo {
        val todo = Todo(text = form.text)

        return this.todoRepository.save(todo)
    }

    fun update(id: Int, form: TodoForm): Todo {
        val optional = this.todoRepository.findById(id)

        if (optional.isEmpty) throw TodoNotFoundException("There is no todo with id: $id")

        val todo = optional.get()
        todo.text = form.text
        todo.done = form.done

        return this.todoRepository.save(todo)
    }

    fun toggle(id: Int): Todo {
        val optional = this.todoRepository.findById(id)

        if (optional.isEmpty) throw TodoNotFoundException("There is no todo with id: $id")

        val todo = optional.get()
        todo.done = !todo.done

        return this.todoRepository.save(todo)
    }

    fun delete(id: Int): List<Todo> {
        this.todoRepository.deleteById(id)

        return this.todoRepository.findAll()
    }
}
