package de.luvfist.api.persistence.repository

import de.luvfist.api.persistence.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Int>
