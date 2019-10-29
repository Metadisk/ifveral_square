package ifveral.square.com.data.Source

import ifveral.square.com.data.model.Square
import io.reactivex.Observable
import retrofit2.http.GET

interface SquareService {

    @GET("orgs/square/repos")
    fun getCakes(): Observable<List<Square>>

}