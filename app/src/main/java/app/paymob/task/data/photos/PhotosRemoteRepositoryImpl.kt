package app.paymob.task.data.photos

import app.paymob.task.domain.photos.entity.PhotosResponse
import app.paymob.task.domain.photos.repository.PhotosRemoteRepository
import app.paymob.task.domain.utils.Resource
import javax.inject.Inject

class PhotosRemoteRepositoryImpl @Inject constructor(private val remoteDataSource: PhotosRemoteDataSource) :
  PhotosRemoteRepository {
  override suspend fun getPhotos(): Resource<PhotosResponse> = remoteDataSource.getPhotos()

}