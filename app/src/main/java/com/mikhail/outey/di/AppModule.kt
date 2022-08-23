package com.mikhail.outey.di

import android.content.Context
import androidx.room.Room
import com.mikhail.outey.core.Constants.Companion.LINKS_TABLE
import com.mikhail.outey.data.network.LinkDao
import com.mikhail.outey.data.network.LinkDb
import com.mikhail.outey.data.repository.LinkRepositoryImpl
import com.mikhail.outey.domain.repository.LinkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideLinkDb(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        LinkDb::class.java,
        LINKS_TABLE
    ).build()

    @Provides
    fun provideLinkDao(
        linkDb: LinkDb
    ) = linkDb.linkDao()

    @Provides
    fun provideLinkRepository(
        linkDao: LinkDao
    ): LinkRepository = LinkRepositoryImpl(
        linkDao = linkDao
    )
}