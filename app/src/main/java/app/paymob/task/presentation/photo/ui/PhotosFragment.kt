package app.paymob.task.presentation.photo.ui

import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.TextView
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
import app.paymob.task.presentation.photo.viewmodel.PhotosViewModel
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

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

    //search on photo
    binding.edtSearch.setOnEditorActionListener(TextView.OnEditorActionListener { textView, i, keyEvent ->
      if (i == EditorInfo.IME_ACTION_SEARCH && textView.text.trim().isNotEmpty()) {
        viewModel.search(textView.text.toString())
        return@OnEditorActionListener true
      }
      false
    })

    binding.edtSearch.addTextChangedListener(
      object : TextWatcher {
        private var timer: Timer = Timer()
        private val DELAY: Long = 1000 // Milliseconds
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
          timer.cancel()
          timer = Timer()
          timer.schedule(
            object : TimerTask() {
              override fun run() {
                viewModel.search(s.toString())
              }

            },
            DELAY
          )
        }
      }
    )


    //listen for photos api
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
              //saving photos
              viewModel.setAllList(it.value.photos.photo)
              //update photos in adapter
              viewModel.setData(it.value.photos.photo)
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
    findNavController().navigate(PhotosFragmentDirections.actionPhotosFragmentToPhotoFragment(photo))
  }

}