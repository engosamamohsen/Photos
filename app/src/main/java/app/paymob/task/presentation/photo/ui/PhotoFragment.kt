package app.paymob.task.presentation.photo.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import app.paymob.task.presentation.base.BaseFragment
import app.paymob.task.presentation.base.extensions.hide
import app.paymob.task.presentation.base.extensions.show
import app.paymob.task.presentation.base.utils.Constants
import app.paymob.task.presentation.base.utils.showMessage
import app.paymob.task.presentation.photo.ui_state.PhotoUIState
import app.paymob.task.presentation.photo.viewmodel.PhotoViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentPhotoBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class PhotoFragment : BaseFragment<FragmentPhotoBinding>(){
  val viewModel: PhotoViewModel by viewModels()
  /** get selected parcelable photo from previous list**/
  private val args : PhotoFragmentArgs by navArgs()

  override
  fun getLayoutId() = R.layout.fragment_photo

  override
  fun setBindingVariables() {
    //represent photo to ui using UI-State
    binding.photo = PhotoUIState(args.photo)
    //set ui to viewModel
    binding.viewModel = viewModel
  }

  private  val TAG = "PhotoFragment"
  override fun setupObservers() {
    super.setupObservers()
    //observe of events from viewModel using liveData
    viewModel.clickEvent.observe(this){
      if(it == Constants.DOWNLOAD){
        downloadImage()
      }
    }
  }

  private fun downloadImage() {
    binding.progress.show()
    Glide.with(this)
      .asBitmap()
      .load(args.photo.imageUrl)
      .into(object : CustomTarget<Bitmap>(){

        override fun onLoadCleared(placeholder: Drawable?) {
          binding.progress.hide()
          showMessage(requireContext(),getString(R.string.failed_to_download_image))
        }

        override fun onResourceReady(
          resource: Bitmap,
          transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
        ) {
          savePhotoInInternalStorage(resource)
        }
      })
  }

  private fun savePhotoInInternalStorage(bmp: Bitmap) : Boolean{
    return try{
      requireActivity().openFileOutput("${args.photo.server}_${args.photo.id}.jpg",
        Context.MODE_PRIVATE).use { stream ->
        if(!bmp.compress(Bitmap.CompressFormat.JPEG,100,stream)){
          binding.progress.hide()
          showMessage(requireContext(),getString(R.string.failed_to_download_image))
          throw IOException("Couldnt save bitmap")
        }
      }
      showMessage(requireContext(),"your image had been downloaded successfully")
      binding.progress.hide()
      true
    }catch (e: IOException){
      binding.progress.hide()
      e.printStackTrace()
      showMessage(requireContext(),getString(R.string.failed_to_download_image))
      false
    }
  }
}