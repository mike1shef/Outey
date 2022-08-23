package com.mikhail.outey.domain.repository

import com.mikhail.outey.domain.model.Link
import kotlinx.coroutines.flow.Flow

interface LinkRepository {

    fun getAllLinksFromRoom() : Flow<List<Link>>

    fun getLinkFromRoom (id : Int) : Flow<Link>

    fun addLinkToRoom (link : Link)

    fun deleteLinkFromRoom (link : Link)


}