package app.paymob.task.domain.photos.repository
import app.paymob.task.domain.photos.entity.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoLocalRepository {
  suspend fun getPhotos(): Flow<List<Photo>>
}