package com.walker.aula5modulo1androidavancado

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class AppDI {

    @Provides
    fun provideTaskNetworkLayer(): TaskNetworkLayer = TaskNetworkLayer()

    @Provides
    fun provideTaskDataSource(taskNetworkLayer: TaskNetworkLayer) = TaskDataSource(taskNetworkLayer)

    @Provides
    fun provideTaskRepository(taskDataSource: TaskDataSource) = TaskRepository(taskDataSource)
}