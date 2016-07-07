package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Id;

/**
 * Created by Lion King on 07-Jul-16.
 */
public class Location {
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAdress='" + streetAdress + '\'' +
                ", postalCOde='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCOde() {
        return postalCode;
    }

    public void setPostalCOde(String postalCOde) {
        this.postalCode = postalCOde;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    private Long id;
    private String streetAdress ;
    private String postalCode;
    private String city;
    private String stateProvince;
}
