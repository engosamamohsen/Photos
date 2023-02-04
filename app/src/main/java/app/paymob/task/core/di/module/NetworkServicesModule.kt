package app.paymob.task.core.di.module

import app.paymob.task.data.photos.PhotosServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/** provide Module NetworkServicesModule for inject retrofit module in photo-Services  **/
@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {
  @Provides
  @Singleton
  fun providePhotosServices(retrofit: Retrofit): PhotosServices =
    retrofit.create(PhotosServices::class.java)

}