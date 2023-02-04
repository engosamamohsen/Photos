package app.paymob.task.data.photos.repository

import app.paymob.task.data.photos.data_source.local.PhotoDao
import app.paymob.task.domain.photos.entity.Photo
import app.paymob.task.domain.photos.repository.PhotoLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoLocalRepositoryImpl @Inject constructor(private val localDataSource: PhotoDao) :
  PhotoLocalRepository {
  override suspend fun getPhotos(): Flow<List<Photo>> = localDataSource.getPhotos()

}