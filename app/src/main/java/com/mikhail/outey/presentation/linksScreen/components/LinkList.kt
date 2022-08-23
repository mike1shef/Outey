package com.mikhail.outey.presentation.linksScreen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mikhail.outey.domain.model.Link


@Composable
@OptIn(ExperimentalMaterialApi::class)
fun LinkList(
    padding: PaddingValues,
    links: List<Link>,
    deleteLink: (link: Link) -> Unit,
    //navigateToUpdateBookScreen: (bookId: Int) -> Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ){
        items(links){ link ->
            LinkItem(
                link = link,
                deleteLink = {
                    deleteLink(link)
                }
            )
        }
    }
}