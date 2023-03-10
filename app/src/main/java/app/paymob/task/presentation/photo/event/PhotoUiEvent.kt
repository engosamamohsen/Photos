package app.paymob.task.presentation.photo.event

import app.paymob.task.domain.photos.entity.Photo

/**
 * Warning: It's bad practice to pass the ViewModel into the RecyclerView adapter
 * because that tightly couples the adapter with the ViewModel class.
 *
 * Note: Another common pattern is for the RecyclerView adapter to have a Callback interface for user actions. In that case,
 * the activity or fragment can handle the binding and call the ViewModel functions directly from the callback interface.
 *
 * More Details
 * https://developer.android.com/topic/architecture/ui-layer/events#views_1
 * **/
interface PhotoUiEvent {
  fun submitPhoto(photo: Photo)
}