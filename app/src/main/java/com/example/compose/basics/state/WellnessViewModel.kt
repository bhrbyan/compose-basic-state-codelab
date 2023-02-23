package com.example.compose.basics.state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _task = getWellnessTaskList().toMutableStateList()
    val task: List<WellnessTask> = _task

    fun remove(task: WellnessTask) {
        _task.remove(task)
    }

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        _task.find { it.id == task.id }?.let {
         it.checked = checked
        }
    }

    private fun getWellnessTaskList() = List(30) {
        WellnessTask(it, "Task $it")
    }
}
