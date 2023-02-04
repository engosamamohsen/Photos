package app.paymob.task.data.photos

import app.paymob.task.domain.photos.entity.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosServices {

  @GET("services/rest/")
  suspend fun getPhotos(
    @Query("method") method: String = "flickr.galleries.getPhotos",
    @Query("gallery_id") galleryId: String = "72157721462865809"
  ): PhotosResponse


}