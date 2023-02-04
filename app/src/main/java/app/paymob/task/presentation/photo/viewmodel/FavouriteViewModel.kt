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
import app.paymob.task.presentation.photo.adapter.PhotosAdapter
import com.structure.base_mvvm.BR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
  private val useCase: PhotosUseCase,
  private val photoLocalUseCase: PhotoLocalDataSource
) : BaseViewModel() {

  @Bindable
  val adapter = PhotosAdapter()

  init {
    viewModelScope.launch {
      photoLocalUseCase.getPhotos().collect {
        setData(it)
      }
    }
  }

  /**update data in photos adapter**/
  fun setData(photos: List<Photo>) {
    adapter.update(photos)
    notifyPropertyChanged(BR.adapter)
  }



}