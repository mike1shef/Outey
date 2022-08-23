package com.mikhail.outey.presentation.linksScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.mikhail.outey.core.Constants.Companion.ADD
import com.mikhail.outey.core.Constants.Companion.ADD_URL
import com.mikhail.outey.core.Constants.Companion.ADD_URL_PLACEHOLDER
import com.mikhail.outey.core.Constants.Companion.DISMISS
import com.mikhail.outey.core.Constants.Companion.EMPTY_STRING
import com.mikhail.outey.domain.model.Link
import kotlinx.coroutines.job

@Composable
fun AddLinkDialog(
    openDialog : Boolean,
    closeDialog : () -> Unit,
    addLink : (link : Link) -> Unit
){
    if (openDialog){
        var url by remember { mutableStateOf(EMPTY_STRING)}
        var focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = ADD_URL
                )
            },
            text = {
                Column() {
                    TextField(
                        value = url,
                        onValueChange = { url = it },
                        placeholder = { Text(ADD_URL_PLACEHOLDER)},
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit){
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                    }
                },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val link = Link(0, url)
                        addLink(link)
                    }
                ) {
                    Text(
                        text = ADD
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = DISMISS
                    )
                }
            }
        )
    }
}
