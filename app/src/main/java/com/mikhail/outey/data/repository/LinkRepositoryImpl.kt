package com.mikhail.outey.data.repository

import com.mikhail.outey.data.network.LinkDao
import com.mikhail.outey.domain.model.Link
import com.mikhail.outey.domain.repository.LinkRepository

class LinkRepositoryImpl (
    private val linkDao: LinkDao
    ) : LinkRepository {
    override fun getAllLinksFromRoom() = linkDao.getLinks()

    override fun getLinkFromRoom(id: Int) = linkDao.getLink(id = id)

    override fun addLinkToRoom(link: Link) = linkDao.addLink(link = link)

    override fun deleteLinkFromRoom(link: Link) = linkDao.deleteLink(link = link)
}