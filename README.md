# Photos List (Kotlin - MVVM - Hilt - Retrofit - Room - Internal storage)

The app is composed of 3 screens,
- first is the to show image with search
- second to show image in full screen with download into internal storage & add to favourite image to local database
- third to list local images from database
with (Kotlin - MVVM - Hilt - Retrofit - Room - internal storage)

For more references :
- **Kotlin** - https://kotlinlang.org/
- **Retrofit** - https://www.raywenderlich.com/6994782-android-networking-with-kotlin-tutorial-getting-started
- **MVVM** - https://www.toptal.com/android/android-apps-mvvm-with-clean-architecture
- **Hilt** - https://developer.android.com/training/dependency-injection/hilt-android
- **Coroutines** - https://developer.android.com/kotlin/coroutines
- **UI layer** -https://developer.android.com/topic/architecture/ui-layer
- **Flow** -https://kotlinlang.org/docs/flow.html
- **Room** -https://developer.android.com/training/data-storage/room

## Application Guide
- **BaseStructure** Consider structure of the Application Layers of Clean Architecture
  Presentation: A layer that interacts with the UI.
  Use cases: Sometimes called interactors. Defines actions the user can trigger.
  Domain: Contains the business logic of the app.
  Data: Abstract definition of all the data sources.
  Framework: Implements interaction with the Android SDK and provides concrete implementations for the data layer.
- **remote-photos** Call Genres Api with Update Data in UI view
- **photo-details** display photo into full screen with Update Data in UI view
- **room-structure** making room layer (Dao - AppDatabase - Entity)
- **room-photos** saving photos into local database (Room)
- **room-photos-list** display saved photos from local stroage
- **photo-save** saving photo into internal storage
- **main** master of application
