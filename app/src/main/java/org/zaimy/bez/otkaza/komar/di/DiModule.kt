package org.zaimy.bez.otkaza.komar.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.zaimy.bez.otkaza.komar.data.RepositoryAnalyticImpl
import org.zaimy.bez.otkaza.komar.data.RepositoryServerImpl
import org.zaimy.bez.otkaza.komar.data.ServiceImpl
import org.zaimy.bez.otkaza.komar.data.SharedKeeperImpl
import org.zaimy.bez.otkaza.komar.domain.RepositoryAnalytic
import org.zaimy.bez.otkaza.komar.domain.RepositoryServer
import org.zaimy.bez.otkaza.komar.domain.Service
import org.zaimy.bez.otkaza.komar.domain.SharedKepper
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceImpl): Service

    @Binds
    @Singleton
    abstract fun bindKeeper(sharedKeeper: SharedKeeperImpl): SharedKepper

    @Binds
    @Singleton
    abstract fun bindRepositoryAnalytic(repository: RepositoryAnalyticImpl): RepositoryAnalytic

    @Binds
    @Singleton
    abstract fun bindRepositoryServer(repository: RepositoryServerImpl): RepositoryServer

}