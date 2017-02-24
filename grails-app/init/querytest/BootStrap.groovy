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

        def logistics = new TodoList(title: "Logistics", parentProject: factorySetUp).save(failOnError: true)
        def offshoreAccounts = new TodoList(title: "Offshore accounts", parentProject: taxOptimization).save(failOnError: true)
        def onlineAds = new TodoList(title: "Online ads", parentProject: hireEngineers).save(failOnError: true)

        new Todo(task: "Buy trucks", parentList: logistics).save(failOnError: true)
        new Todo(task: "Caiman islands", parentList: offshoreAccounts).save(failOnError: true)
        new Todo(task: "LinkedIn", parentList: onlineAds).save(failOnError: true)
        new Todo(task: "Hire accountant", parentProject: taxOptimization).save(failOnError: true)
        new Todo(task: "Buy coffee machine", parentProject: hireEngineers).save(failOnError: true)
    }
    def destroy = {
    }
}
