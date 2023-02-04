package app.paymob.task.presentation.photo.ui_state

import app.paymob.task.domain.photos.entity.Photo

/**
 * carry ui represent in photo screen
 * https://developer.android.com/topic/architecture/ui-layer
 * **/
class PhotoUIState(val photo: Photo) {

  fun getPhotoTitle():String = photo.title

  fun getPhotoUrl(): String = photo.imageUrl
}