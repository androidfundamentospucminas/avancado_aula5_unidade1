package com.walker.aula5modulo1androidavancado

import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDataSource: TaskDataSource
) {
    fun getTasks() = taskDataSource.getTasks()

    fun addTask(task: TaskModel) = taskDataSource.addTask(task)

    fun updateTask(position: Int) = taskDataSource.updateTask(position)

    fun deleteTask(position: Int) = taskDataSource.deleteTask(position)
}