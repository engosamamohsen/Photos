package app.paymob.task.presentation.photo.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import app.paymob.task.domain.photos.entity.Photo
import app.paymob.task.domain.photos.entity.Photos
import app.paymob.task.domain.photos.entity.PhotosResponse
import app.paymob.task.domain.photos.usecase.PhotosUseCase
import app.paymob.task.domain.utils.Resource
import app.paymob.task.presentation.base.BaseViewModel
import app.paymob.task.presentation.photo.adapter.PhotosAdapter
import com.structure.base_mvvm.BR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
  private val useCase: PhotosUseCase,
) : BaseViewModel() {
  private val TAG = "HomeViewModel"

  /** collect photos api for listening in fragment **/
  val photosResponse = MutableStateFlow<Resource<PhotosResponse>>(Resource.Default)

  @Bindable
  val adapter = PhotosAdapter()

  init {
    getPhotos()
  }


  /** Get photos Api using useCase invoke function **/
  private fun getPhotos() {
    useCase().onEach {
      photosResponse.value = it
    }.launchIn(viewModelScope)
  }

  /**update data in photos adapter**/
  fun setData(photos: Photos) {
    adapter.update(photos.photo)
    notifyPropertyChanged(BR.adapter)
  }



}