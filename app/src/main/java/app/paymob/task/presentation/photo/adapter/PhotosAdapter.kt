package app.paymob.task.presentation.photo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.paymob.task.domain.photos.entity.Photo
import app.paymob.task.presentation.photo.event.PhotoUiEvent
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.ItemPhotoBinding
import javax.inject.Inject

class PhotosAdapter @Inject constructor() : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
  lateinit var photoUiEvent: PhotoUiEvent
  var list = ArrayList<Photo>()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val data = list[position]
    holder.itemLayoutBinding.photo = data
    if(this::photoUiEvent.isInitialized) holder.itemLayoutBinding.photoUiEvent = photoUiEvent
  }

  override fun getItemCount(): Int {
    return list.size
  }

  override fun onViewAttachedToWindow(holder: ViewHolder) {
    super.onViewAttachedToWindow(holder)
    holder.bind()
  }

  override fun onViewDetachedFromWindow(holder: ViewHolder) {
    super.onViewDetachedFromWindow(holder)
    holder.unBind()
  }

  fun update(photos: List<Photo>) {
    list.clear()
    list.addAll(photos)
    notifyDataSetChanged()
  }

  inner class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    lateinit var itemLayoutBinding: ItemPhotoBinding

    init {
      bind()
    }

    fun bind() {
      itemLayoutBinding = DataBindingUtil.bind(itemView)!!
    }

    fun unBind() {
      itemLayoutBinding.unbind()
    }
  }

}