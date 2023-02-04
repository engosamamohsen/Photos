package app.paymob.task.presentation.photo.ui

import androidx.navigation.fragment.navArgs
import app.paymob.task.presentation.base.BaseFragment
import app.paymob.task.presentation.photo.ui_state.PhotoUIState
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentPhotoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : BaseFragment<FragmentPhotoBinding>(){

  /** get selected parcelable photo from previous list**/
  private val args : PhotoFragmentArgs by navArgs()

  override
  fun getLayoutId() = R.layout.fragment_photo

  override
  fun setBindingVariables() {
    binding.photo = PhotoUIState(args.photo)
  }
}