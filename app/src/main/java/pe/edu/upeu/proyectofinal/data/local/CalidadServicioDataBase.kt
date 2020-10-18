package pe.edu.upeu.proyectofinal.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.upeu.proyectofinal.model.Producto
import pe.edu.upeu.proyectofinal.data.local.dao.ProductoDao

@Database(
    entities = arrayOf(Producto::class), version = DatabaseMigration.DB_VERSION
)

abstract class CalidadServicioDataBase: RoomDatabase() {
    abstract fun getProductoDao(): ProductoDao

    companion object {
        const val DB_NAME = "calidad_servicio"

        @Volatile
        private var INSTANCE: CalidadServicioDataBase? = null

        fun getInstance(context: Context): CalidadServicioDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalidadServicioDataBase::class.java,
                    DB_NAME
                ).addMigrations(*DatabaseMigration.MIGRATIONS).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}