package app.paymob.task.presentation.photo.viewmodel

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
  @Bindable
  var isFavourite: Boolean = false

  fun isExistInFavourite(photoId: Int){

  }

  fun changeFav(){
    when(isFavourite){
      true -> {}
      else -> {}
    }
  }

  fun download(){
    clickEvent.value = Constants.DOWNLOAD
  }
}