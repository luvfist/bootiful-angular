import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Todo } from "../model/Todo";
import { environment } from "../../../environments/environment"

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private httpClient: HttpClient) {
  }

  fetchTodos(): Observable<Todo[]> {
    const url = `${environment.apiHost}/todos`;

    return this.httpClient.get<Todo[]>(url)
  }

  toggle(id: number) {
    const url = `${environment.apiHost}/todos/${id}/toggle`;

    return this.httpClient.get<Todo>(url).subscribe()
  }

  delete(id: number): Observable<Todo[]> {
    const url = `${environment.apiHost}/todos/${id}`;

    return this.httpClient.delete<Todo[]>(url)
  }
}
