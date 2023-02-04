package app.paymob.task.presentation.photo.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import app.paymob.task.domain.photos.entity.Photo
import app.paymob.task.domain.utils.Resource
import app.paymob.task.presentation.base.BaseFragment
import app.paymob.task.presentation.base.extensions.handleApiError
import app.paymob.task.presentation.base.extensions.hideKeyboard
import app.paymob.task.presentation.base.extensions.setUpAdapter
import app.paymob.task.presentation.photo.event.PhotoUiEvent
import app.paymob.task.presentation.photo.viewmodel.FavouriteViewModel
import app.paymob.task.presentation.photo.viewmodel.PhotosViewModel
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentFavouriteBinding
import com.structure.base_mvvm.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FragmentFavouriteBinding>() , PhotoUiEvent{

  private val viewModel: FavouriteViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_favourite

  override
  fun setBindingVariables() {
    viewModel.adapter.photoUiEvent = this
    binding.rvPhotos.setUpAdapter(viewModel.adapter,"2","1")
  }

  override fun submitPhoto(photo: Photo) {
    findNavController().navigate(FavouriteFragmentDirections.actionFavouriteFragmentToPhotoFragment(photo))
  }

}