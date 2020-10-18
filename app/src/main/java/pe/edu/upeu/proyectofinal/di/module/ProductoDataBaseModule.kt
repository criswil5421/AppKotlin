package pe.edu.upeu.proyectofinal.di.module

import android.app.Application
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import pe.edu.upeu.proyectofinal.data.local.CalidadServicioDataBase
import javax.inject.Singleton

@InstallIn(ApplicationComponent:: class)
@Module
class ProductoDataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(application:Application)= CalidadServicioDataBase.getInstance(application)

    @Singleton
    @Provides
    fun provideProductoDao(database: CalidadServicioDataBase) = database.getProductoDao()

}