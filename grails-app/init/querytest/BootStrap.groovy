package querytest

import com.epseelon.Project
import com.epseelon.ProjectType
import com.epseelon.Todo
import com.epseelon.TodoList

class BootStrap {

    def init = { servletContext ->
        def factorySetUp = new Project(name: "Factory set up", type: ProjectType.ENGINEERING).save(failOnError: true)
        def taxOptimization = new Project(name: "Tax optimization", type: ProjectType.ADMINISTRATIVE).save(failOnError: true)
        def hireEngineers = new Project(name: "Hire more engineers", type: ProjectType.STRATEGIC).save(failOnError: true)

        def logistics = new TodoList(title: "Logistics", project: factorySetUp).save(failOnError: true)
        def offshoreAccounts = new TodoList(title: "Offshore accounts", project: taxOptimization).save(failOnError: true)
        def onlineAds = new TodoList(title: "Online ads", project: hireEngineers).save(failOnError: true)

        new Todo(task: "Buy trucks", list: logistics).save(failOnError: true)
        new Todo(task: "Caiman islands", list: offshoreAccounts).save(failOnError: true)
        new Todo(task: "LinkedIn", list: onlineAds).save(failOnError: true)
        new Todo(task: "Hire accountant", project: taxOptimization).save(failOnError: true)
        new Todo(task: "Buy coffee machine", project: hireEngineers).save(failOnError: true)
    }
    def destroy = {
    }
}
