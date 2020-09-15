package de.luvfist.api.persistence.service

import java.lang.RuntimeException

class TodoNotFoundException(msg: String) : RuntimeException(msg)
