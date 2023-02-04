package app.paymob.task.data.photos.data_source.local

import app.paymob.task.data.remote.BaseRemoteDataSource
import app.paymob.task.domain.photos.entity.Photo
import javax.inject.Inject

class PhotoLocalDataSource @Inject constructor(private val dao: PhotoDao) :
  BaseRemoteDataSource() {

  fun getPhotos() = dao.getPhotos()

  suspend fun insert(list: List<Photo>) = safeApiCall {
    dao.insert(list)
  }


}