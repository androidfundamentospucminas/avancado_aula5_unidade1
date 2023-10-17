package com.walker.aula5modulo1androidavancado

import javax.inject.Inject

class TaskDataSource @Inject constructor(
    private val taskNetworkLayer: TaskNetworkLayer
) {
    fun getTasks() = taskNetworkLayer.getTasks()

    fun addTask(task: TaskModel) = taskNetworkLayer.addTask(task)

    fun updateTask(position: Int) = taskNetworkLayer.updateTask(position)

    fun deleteTask(position: Int) = taskNetworkLayer.deleteTask(position)
}