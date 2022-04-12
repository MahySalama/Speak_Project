
package com.mycompany.superherosightings.dao;

import com.mycompany.superherosightings.models.Location;
import com.mycompany.superherosightings.models.Hero;
import java.util.List;

public interface LocationDao {
    
    Location getLocationById(int id);
    List<Location> getAllLocations();
    Location addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocationById(int id);
    
    List<Location> getLocationsForHero(Hero hero);
}
