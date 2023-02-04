package app.paymob.task.data.photos

import app.paymob.task.data.remote.BaseRemoteDataSource
import javax.inject.Inject

class PhotosRemoteDataSource @Inject constructor(private val apiService: PhotosServices) :
  BaseRemoteDataSource() {
  suspend fun getPhotos() = safeApiCall {
    apiService.getPhotos()
  }

}