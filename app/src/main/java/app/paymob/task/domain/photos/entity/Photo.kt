package app.paymob.task.domain.photos.entity


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "photo")
@Keep
@Parcelize
data class Photo(
  @PrimaryKey(autoGenerate = true)
  var roomId: Int = 0,
  @SerializedName("farm")
  @Expose
  var farm: Int = 0,
  @SerializedName("has_comment")
  @Expose
  var hasComment: Int = 0,
  @SerializedName("id")
  @ColumnInfo(name = "id")
  @Expose
  var id: String = "",
  @SerializedName("is_primary")
  @Expose
  var isPrimary: Int = 0,
  @SerializedName("isfamily")
  @Expose
  var isfamily: Int = 0,
  @SerializedName("isfriend")
  @Expose
  var isfriend: Int = 0,
  @SerializedName("ispublic")
  @Expose
  var ispublic: Int = 0,
  @SerializedName("owner")
  @Expose
  var owner: String = "",
  @SerializedName("secret")
  @Expose
  var secret: String = "",
  @SerializedName("server")
  @Expose
  var server: String = "",
  @SerializedName("title")
  @ColumnInfo(name = "title")
  @Expose
  var title: String = "",
  @ColumnInfo(name = "image")
  var imageUrl: String = ""
) : Parcelable