package com.epseelon

class Todo {
    String task

    static belongsTo = [
            parentList: TodoList,
            parentProject: Project
    ]

    static constraints = {
        parentList nullable: true
        parentProject nullable: true
    }
}
