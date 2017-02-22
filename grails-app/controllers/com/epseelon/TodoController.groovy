package com.epseelon

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TodoController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max, String projectType) {
        def type = projectType ? ProjectType.valueOf(projectType) : null
        params.max = Math.min(max ?: 10, 100)
        if(type) {
            def todoQuery = Todo.where {
                project.type == type || list.project.type == type
            }
            respond todoQuery.list(params), model: [todoCount: todoQuery.count()]
        } else {
            respond Todo.list(params), model:[todoCount: Todo.count()]
        }
    }

    def show(Todo todo) {
        respond todo
    }

    @Transactional
    def save(Todo todo) {
        if (todo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (todo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond todo.errors, view:'create'
            return
        }

        todo.save flush:true

        respond todo, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Todo todo) {
        if (todo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (todo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond todo.errors, view:'edit'
            return
        }

        todo.save flush:true

        respond todo, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Todo todo) {

        if (todo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        todo.delete flush:true

        render status: NO_CONTENT
    }
}
