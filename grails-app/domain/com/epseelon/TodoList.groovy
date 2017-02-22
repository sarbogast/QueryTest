package com.epseelon

class TodoList {
    String title

    static belongsTo = [
            project: Project
    ]

    static hasMany = [
            todos: Todo
    ]

    static constraints = {
    }
}
