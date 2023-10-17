package com.walker.aula5modulo1androidavancado

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
): ViewModel() {

    private val tasks_: MutableLiveData<List<TaskModel>> = MutableLiveData(taskRepository.getTasks())
    val tasks: LiveData<List<TaskModel>> = tasks_

    fun addTask(task: TaskModel) {
        tasks_.value = taskRepository.addTask(task)
    }

    fun updateTask(position: Int) {
        tasks_.value = taskRepository.updateTask(position)
    }

    fun deleteTask(position: Int) {
        tasks_.value = taskRepository.deleteTask(position)
    }
}