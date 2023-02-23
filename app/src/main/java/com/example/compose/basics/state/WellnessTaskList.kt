package com.example.compose.basics.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(
        modifier,
        state = rememberLazyListState()
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { item: WellnessTask ->
            WellnessTaskItem(
                taskName = item.label,
                checked = item.checked,
                onClose = { onCloseTask(item) },
                onCheckedChange = { checked ->
                    onCheckedTask(item, checked)
                }
            )
        }
    }
}