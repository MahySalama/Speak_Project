
package com.mycompany.superherosightings.dao;

import com.mycompany.superherosightings.models.Hero;
import com.mycompany.superherosightings.models.Location;
import com.mycompany.superherosightings.models.Sighting;
import com.mycompany.superherosightings.models.Superpower;
import java.util.List;

public interface HeroDao {
    
    Hero getHeroById(int id);
    List<Hero> getAllHeros();
    Hero addHero(Hero hero);
    void updateHero(Hero hero);
    void deleteHeroById(int id);
    
    List<Hero> getHerosForSuperpower(Superpower superpower);
    Hero getHeroForSighting(Sighting sighting);
    List<Hero> getHerosForLocation(Location location);
}
