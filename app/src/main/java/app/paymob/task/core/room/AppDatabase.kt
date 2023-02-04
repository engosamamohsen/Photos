package app.paymob.task.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import app.paymob.task.data.photos.data_source.local.PhotoDao
import app.paymob.task.domain.photos.entity.Photo

@Database(
  entities = [Photo::class],
  version = 1
)
abstract class AppDatabase : RoomDatabase() {
  abstract val getPhotos: PhotoDao
}