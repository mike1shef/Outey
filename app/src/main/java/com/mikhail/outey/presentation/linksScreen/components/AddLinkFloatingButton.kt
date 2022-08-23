package com.mikhail.outey.presentation.linksScreen.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.mikhail.outey.core.Constants.Companion.ADD_LINK

@Composable
fun AddLinkFloatingButton(
    openDialog: () -> Unit
){
    FloatingActionButton(
        onClick = openDialog,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_LINK
        )

    }
}