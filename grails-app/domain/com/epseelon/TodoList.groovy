package com.epseelon

class TodoList {
    String title

    static belongsTo = [
            parentProject: Project
    ]

    static hasMany = [
            todos: Todo
    ]

    static constraints = {
    }
}
