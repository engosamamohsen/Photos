package app.paymob.task.domain.photos.repository

import app.paymob.task.domain.photos.entity.PhotosResponse
import app.paymob.task.domain.utils.Resource

interface PhotosRemoteRepository {
  suspend fun getPhotos(): Resource<PhotosResponse>
}