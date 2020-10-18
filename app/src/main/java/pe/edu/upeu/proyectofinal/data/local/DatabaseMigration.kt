package pe.edu.upeu.proyectofinal.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseMigration {
    const val DB_VERSION=2
    val MIGRATIONS:Array<Migration>
        get()= arrayOf<Migration>(

        )
    private fun migration12():Migration=object : Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            TODO("Not yet implemented")
        }
    }
}