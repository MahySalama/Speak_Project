
package com.mycompany.superherosightings.dao;

import com.mycompany.superherosightings.models.Hero;
import com.mycompany.superherosightings.models.Sighting;
import com.mycompany.superherosightings.models.Location;
import java.util.List;

public interface SightingDao {
    
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    Sighting addSighting(Sighting sighting);
    void updateSighting(Sighting sighting);
    void deleteSightingById(int id);
    
    List<Sighting> getSightingsForLocation(Location location);
}
