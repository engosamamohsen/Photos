package app.paymob.task.core.di.module

import app.paymob.task.domain.photos.repository.PhotosRemoteRepository
import app.paymob.task.domain.photos.usecase.PhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** provide module for repository in UseCase **/
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
  @Provides
  @Singleton
  fun providePhotosUseCase(
    repository: PhotosRemoteRepository,
  ): PhotosUseCase = PhotosUseCase(repository)

}