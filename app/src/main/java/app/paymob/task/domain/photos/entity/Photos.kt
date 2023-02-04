package app.paymob.task.domain.photos.entity


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class Photos(
  @SerializedName("page")
    @Expose
    var page: Int = 0,
  @SerializedName("pages")
    @Expose
    var pages: Int = 0,
  @SerializedName("perpage")
    @Expose
    var perpage: Int = 0,
  @SerializedName("photo")
    @Expose
    var photo: List<Photo> = listOf(),
  @SerializedName("total")
    @Expose
    var total: Int = 0
)