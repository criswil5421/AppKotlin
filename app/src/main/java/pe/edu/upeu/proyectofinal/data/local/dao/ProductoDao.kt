package pe.edu.upeu.proyectofinal.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pe.edu.upeu.proyectofinal.model.Producto

@Dao
interface ProductoDao {

    @Query("SELECT * FROM producto")
    fun getAllProducto(): Flow<List<Producto>>


    @Query("SELECT * FROM producto where id=:productoid")
    fun getProductoById(productoid: Int): Flow<Producto>


    @Query("delete FROM producto where id=:productoid")
    suspend fun deleteProducto(productoid: Int): Flow<List<Producto>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducto(producto: List<Producto>)
}