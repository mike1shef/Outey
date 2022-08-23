package com.mikhail.outey.presentation.linksScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhail.outey.core.Constants.Companion.DELETE_LINK
import com.mikhail.outey.domain.model.Link

@ExperimentalMaterialApi
@Composable
fun LinkItem(
    link: Link,
    deleteLink: () -> Unit,
){
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {/**Enter action on click*/}
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    all = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(
                        fraction = 0.90f
                    )
            ){
                Text(
                    text = link.link,
                    color = Color.DarkGray,
                    fontSize = 25.sp
                )
            }
            IconButton(
                onClick = deleteLink
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = DELETE_LINK,
                    tint = MaterialTheme.colors.onSurface
                )
            }
        }
    }
}