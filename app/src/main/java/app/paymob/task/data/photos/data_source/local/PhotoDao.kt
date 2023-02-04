package app.paymob.task.data.photos.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.paymob.task.domain.photos.entity.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {
  //select photos from table
  @Query("Select * from photo")
  fun getPhotos(): Flow<List<Photo>>

  //insert photo into table
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(photos: List<Photo>)

  //remove photo by photo_id
  @Query("DELETE from photo where id=:photoId")
  fun remove(photoId: String)

  //check photo is exist for updating favourite icon
  @Query("Select COUNT (*) from photo where id=:photoId")
  fun exists(photoId: String): Flow<Int>



}