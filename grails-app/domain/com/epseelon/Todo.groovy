package com.epseelon

class Todo {
    String task

    static belongsTo = [
            list: TodoList,
            project: Project
    ]

    static constraints = {
        list nullable: true
        project nullable: true
    }
}
