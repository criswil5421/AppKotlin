package pe.edu.upeu.proyectofinal.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import pe.edu.upeu.proyectofinal.data.local.dao.ProductoDao
import pe.edu.upeu.proyectofinal.data.remote.ServiciosCalidadApi
import pe.edu.upeu.proyectofinal.model.Producto
import pe.edu.upeu.proyectofinal.model.State
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
class ProductoRepository @Inject constructor(
    private val productoDao:ProductoDao,
    private val servicioproducto: ServiciosCalidadApi
){

    fun getAllProducto(): Flow<State<List<Producto>>>{
        return object : NetworkBoundRepository<List<Producto>, List<Producto>>(){
            override suspend fun saveRemoteData(response: List<Producto>) = productoDao.insertProducto(response)
            override  fun fetchFromLocal(): Flow<List<Producto>> = productoDao.getAllProducto()
            override suspend fun fetchFromRemote(): Response<List<Producto>> = servicioproducto.getProducto()
        }.asFlow()
    }

    fun getProductoById(productoId: Int): Flow<Producto> = productoDao.getProductoById(productoId)
}