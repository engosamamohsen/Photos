package app.paymob.task.presentation.photo.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import app.paymob.task.data.photos.data_source.local.PhotoLocalDataSource
import app.paymob.task.domain.photos.entity.Photo
import app.paymob.task.domain.photos.entity.Photos
import app.paymob.task.domain.photos.entity.PhotosResponse
import app.paymob.task.domain.photos.usecase.PhotosUseCase
import app.paymob.task.domain.utils.Resource
import app.paymob.task.presentation.base.BaseViewModel
import app.paymob.task.presentation.base.utils.Constants
import app.paymob.task.presentation.photo.adapter.PhotosAdapter
import com.structure.base_mvvm.BR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
  private val useCase: PhotoLocalDataSource,
) : BaseViewModel() {
  lateinit var photo: Photo
  @Bindable
  var favourite: Boolean = false

  //check exists for favourite icon
  fun isExistInFavourite(){
    viewModelScope.launch {
      //listen for favourite had been added into room or not
      useCase.exists(photo.id).collect{
        favourite = it > 0
        notifyPropertyChanged(BR.favourite)
      }
    }
  }

  //set photo model
  fun setPhotoModel(photo: Photo){
    this.photo = photo
    isExistInFavourite()
  }

  //change favourite (remove if exists or add if not exist)
  fun changeFav(){
    when(favourite){
      true -> {
        viewModelScope.launch {
          useCase.remove(photo.id)
          cancel()
        }
      }
      else -> {
        viewModelScope.launch {
          useCase.insert(arrayListOf<Photo>().apply {
            add(photo)
          })
          cancel()
        }
      }
    }
  }

  //download image into internal storage
  fun download(){
    clickEvent.value = Constants.DOWNLOAD
  }
}