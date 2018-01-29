package dekkan100.appsmatic.com.dekkan100.API.WebService;

import dekkan100.appsmatic.com.dekkan100.API.Countries.ResCountry;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Eng Ali on 1/29/2018.
 */
public interface DekkanApi {

    //Get Countries Kuwait Saudi
    @GET("api/countries?")
    Call<ResCountry> getCountries(@Query("ids") String id);


}
