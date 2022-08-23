package com.mikhail.outey.presentation.linksScreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikhail.outey.presentation.linksScreen.components.AddLinkDialog
import com.mikhail.outey.presentation.linksScreen.components.AddLinkFloatingButton
import com.mikhail.outey.presentation.linksScreen.components.LinkList


@Composable
fun LinksScreen(
    viewModel: LinksViewModel = hiltViewModel()
    ){
    LaunchedEffect(Unit){
        viewModel.getLinks()
    }
    Scaffold(
        content = { padding ->
            LinkList(
                padding = padding,
                links = viewModel.links,
                deleteLink = { link ->
                    viewModel.deleteLink(link)
                }
            )
            AddLinkDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                              viewModel.closeDialog()
                },
                addLink = { link ->
                    viewModel.addLink(link)
                }
            )
        },
        floatingActionButton = {
            AddLinkFloatingButton (
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}