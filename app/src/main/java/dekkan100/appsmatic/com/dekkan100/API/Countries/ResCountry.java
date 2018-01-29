package dekkan100.appsmatic.com.dekkan100.API.Countries;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import dekkan100.appsmatic.com.dekkan100.API.Countries.Country;

/**
 * Created by Eng Ali on 1/29/2018.
 */
public class ResCountry {
    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
