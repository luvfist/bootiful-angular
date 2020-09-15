import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Todo } from "../../model/Todo";
import { TodoService } from "../../service/todo.service";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {

  todos: Observable<Todo[]>

  constructor(private todoService: TodoService) {
  }

  ngOnInit(): void {
    this.todos = this.todoService.fetchTodos()
  }

  toggle(id: number) {
    this.todoService.toggle(id)
  }

  delete(id: number) {
    this.todos = this.todoService.delete(id)
  }
}
