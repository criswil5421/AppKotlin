package pe.edu.upeu.proyectofinal.data.remote

import pe.edu.upeu.proyectofinal.model.Producto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiciosCalidadApi {

    @GET("/producto/lista")
    suspend fun getProducto():Response<List<Producto>>

    @GET("/producto/detail/{id}")
    suspend fun getProductoById(@Query("id") id: Int): Call<Producto>


    companion object{
        const val SERVICIOS_CALIDAD_API_URL = "http://60.60.60.89:8080/"
    }
}