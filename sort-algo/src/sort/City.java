package sort;

public class City {
    private final String name;

    private final String city_ascii;

    private final double longitude;

    private final double latitude;
    private final String country;

    private final String iso2;
    private final String iso3;
    private final String adminName;
    private final String capital;
    private final String population;
    private final String id;


    public City(String name, String cityAscii, double longitude, double latitude, String country, String iso2, String iso3, String adminName, String capital, String population, String  id) {
        this.name = name;
        this.city_ascii = cityAscii;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.adminName = adminName;
        this.capital = capital;
        this.population = population;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity_ascii() {
        return city_ascii;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getCountry() {
        return country;
    }

    public String getIso2() {
        return iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", city_ascii='" + city_ascii + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", country='" + country + '\'' +
                ", iso2='" + iso2 + '\'' +
                ", iso3='" + iso3 + '\'' +
                ", adminName='" + adminName + '\'' +
                ", capital='" + capital + '\'' +
                ", population='" + population + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
