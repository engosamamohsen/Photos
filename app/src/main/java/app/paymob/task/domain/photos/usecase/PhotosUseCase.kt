package app.paymob.task.domain.photos.usecase

import app.paymob.task.domain.photos.entity.PhotosResponse
import app.paymob.task.domain.photos.repository.PhotosRemoteRepository
import app.paymob.task.domain.utils.Resource
import app.paymob.task.presentation.base.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class PhotosUseCase @Inject constructor(
  private val repository: PhotosRemoteRepository
) {
  /**
   * invoke function will be call directly
   * */
  operator fun invoke(): Flow<Resource<PhotosResponse>> = flow {
    emit(Resource.Loading) //show loader
    val result = repository.getPhotos() //call api photos
    if (result is Resource.Success) {
      result.value.photos.photo.map {
        it.imageUrl = "${Constants.IMAGE_PATH}${it.server}/${it.id}_${it.secret}.jpg"
      }
    }
    emit(result)//send result for collecting
  }.flowOn(Dispatchers.IO)

}