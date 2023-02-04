package app.paymob.task.core.di.module

import app.paymob.task.data.photos.data_source.remote.PhotosRemoteDataSource
import app.paymob.task.data.photos.repository.PhotosRemoteRepositoryImpl
import app.paymob.task.domain.photos.repository.PhotosRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** provide module for repository to use remoteDataSource in Repository **/
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
  @Provides
  @Singleton
  fun providePhotosRepository(
    remoteDataSource: PhotosRemoteDataSource
  ): PhotosRemoteRepository = PhotosRemoteRepositoryImpl(remoteDataSource)

}