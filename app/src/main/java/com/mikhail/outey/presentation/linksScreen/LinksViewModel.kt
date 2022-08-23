package com.mikhail.outey.presentation.linksScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.outey.domain.model.Link
import com.mikhail.outey.domain.repository.LinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LinksViewModel @Inject constructor(
    private val repo : LinkRepository
) : ViewModel() {
    var links by mutableStateOf(emptyList<Link>())
    var link by mutableStateOf(Link (id = 0, link = ""))
    var openDialog by mutableStateOf(false)

    fun getLinks() = viewModelScope.launch {
        repo.getAllLinksFromRoom().collect{ dbLinks ->
            links = dbLinks
        }
    }

    fun getLink(id : Int) = viewModelScope.launch {
        repo.getLinkFromRoom(id).collect{ dbLink ->
            link = dbLink
        }
    }

    fun addLink (link: Link) = viewModelScope.launch (Dispatchers.IO)  {
        repo.addLinkToRoom(link)
    }

    fun deleteLink (link: Link) = viewModelScope.launch (Dispatchers.IO) {
        repo.deleteLinkFromRoom(link)
    }

    fun updateMemoLink (title : String){
        link = link.copy(
            link = title
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}
