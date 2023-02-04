package app.paymob.task.presentation.photo

import app.paymob.task.presentation.base.BaseFragment
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding>(){

  override
  fun getLayoutId() = R.layout.fragment_photos
}