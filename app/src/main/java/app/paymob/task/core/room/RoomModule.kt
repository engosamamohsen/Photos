package app.paymob.task.core.room

import android.content.Context
import androidx.room.Room
import app.paymob.task.data.photos.data_source.local.PhotoLocalDataSource
import com.structure.base_mvvm.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
  @Provides
  @Singleton
  fun provideMyDB(@ApplicationContext context: Context): AppDatabase {
    return Room.databaseBuilder(
      context,
      AppDatabase::class.java,
      BuildConfig.ROOM_DB
    )
      .allowMainThreadQueries()
      .fallbackToDestructiveMigration()
//      .addMigrations(MIGRATION_1_2)
      .build()
  }

  @Provides
  @Singleton
  fun provideLocalPhotoRepository(db: AppDatabase): PhotoLocalDataSource {
    return PhotoLocalDataSource(db.getPhotos)
  }

}



