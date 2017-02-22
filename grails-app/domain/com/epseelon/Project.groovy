package com.epseelon

class Project {
    String name

    ProjectType type

    static hasMany = [
            lists: TodoList,
            todos: Todo
    ]

    static constraints = {
    }
}
