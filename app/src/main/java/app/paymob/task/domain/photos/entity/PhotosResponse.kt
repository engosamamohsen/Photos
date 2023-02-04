package app.paymob.task.domain.photos.entity


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class PhotosResponse(
  @SerializedName("photos")
    @Expose
    var photos: Photos = Photos(),
  @SerializedName("stat")
    @Expose
    var stat: String = ""
)