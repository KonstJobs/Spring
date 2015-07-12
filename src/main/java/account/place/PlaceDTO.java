/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.place;

/**
 *
 * @author konst
 */
public class PlaceDTO {

    private String description;
    private String title;
    private double longitude;
    private double latitude;

    public PlaceDTO(String description, String title, double longitude, double latitude) {
        this.description = description;
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
    
    
    
}
