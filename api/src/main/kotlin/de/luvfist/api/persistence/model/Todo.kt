package de.luvfist.api.persistence.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = -1,
        var text: String = "",
        var done: Boolean = false
)
