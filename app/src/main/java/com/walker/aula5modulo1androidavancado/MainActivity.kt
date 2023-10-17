package com.walker.aula5modulo1androidavancado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModels()

    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TaskAdapter(this, taskViewModel.tasks.value ?: listOf())

        val tasksList = findViewById<ListView>(R.id.tasksList)

        tasksList.adapter = adapter

        taskViewModel.tasks.observe(this) {
            adapter.notifyDataSetChanged()
        }

        tasksList.setOnItemLongClickListener { _, _, position, _ ->
            // Remove a task
            taskViewModel.deleteTask(position)
            true
        }

        tasksList.setOnItemClickListener { _, _, position, _ ->
            // Atualiza isCompleted da task
            taskViewModel.updateTask(position)
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            // Adiciona nova task
            val newTask = TaskModel("Nova Tarefa", "Descricao da Nova Tarefa", false)
            taskViewModel.addTask(newTask)
        }
    }
}