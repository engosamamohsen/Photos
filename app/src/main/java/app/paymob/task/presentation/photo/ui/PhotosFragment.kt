package app.paymob.task.presentation.photo.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import app.paymob.task.domain.photos.entity.Photo
import app.paymob.task.domain.utils.Resource
import app.paymob.task.presentation.base.BaseFragment
import app.paymob.task.presentation.base.extensions.handleApiError
import app.paymob.task.presentation.base.extensions.hideKeyboard
import app.paymob.task.presentation.base.extensions.setUpAdapter
import app.paymob.task.presentation.photo.event.PhotoUiEvent
import app.paymob.task.presentation.photo.viewmodel.PhotosViewModel
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding>() , PhotoUiEvent{

  private val viewModel: PhotosViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_photos

  override
  fun setBindingVariables() {
    viewModel.adapter.photoUiEvent = this
    binding.rvPhotos.setUpAdapter(viewModel.adapter,"2","1")
  }

  override fun setupObservers() {
    super.setupObservers()

    //listen for categories api
    lifecycleScope.launchWhenResumed {
      viewModel.photosResponse
        .collect {
          when (it) {
            Resource.Loading -> {
              hideKeyboard()
              showLoading()
            }
            is Resource.Success -> {
              hideLoading()
              //update photos in adapter
              viewModel.setData(it.value.photos)
            }
            is Resource.Failure -> {
              hideLoading()
              handleApiError(it)
            }
            else -> {}
          }
        }
    }
  }
  override fun submitPhoto(photo: Photo) {

  }

}