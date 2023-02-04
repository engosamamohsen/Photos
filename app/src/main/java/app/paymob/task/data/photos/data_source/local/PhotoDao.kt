package app.paymob.task.data.photos.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.paymob.task.domain.photos.entity.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {
  @Query("Select * from photo")
  fun getPhotos(): Flow<List<Photo>>


  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(photos: List<Photo>)
}