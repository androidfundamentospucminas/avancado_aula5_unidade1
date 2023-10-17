package com.walker.aula5modulo1androidavancado

class TaskNetworkLayer {

    private var tasks: MutableList<TaskModel> = mutableListOf()

    init {
        addTask(TaskModel("Tarefa 1", "Descricao Nova Tarefa 1", true))
        addTask(TaskModel("Tarefa 2", "Descricao Nova Tarefa 2", false))
        addTask(TaskModel("Tarefa 3", "Descricao Nova Tarefa 3", false))
    }

    fun getTasks() = tasks

    fun addTask(task: TaskModel): List<TaskModel> {
        tasks.add(task)
        return tasks
    }

    fun updateTask(position: Int): List<TaskModel> {
        tasks[position].isCompleted = !tasks[position].isCompleted
        return tasks
    }

    fun deleteTask(position: Int): List<TaskModel> {
        tasks.remove(tasks[position])
        return tasks
    }

}