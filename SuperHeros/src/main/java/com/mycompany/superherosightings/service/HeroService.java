
package com.mycompany.superherosightings.service;

import com.mycompany.superherosightings.dao.HeroDao;
import com.mycompany.superherosightings.dao.LocationDao;
import com.mycompany.superherosightings.dao.OrganizationDao;
import com.mycompany.superherosightings.dao.SightingDao;
import com.mycompany.superherosightings.dao.SuperpowerDao;
import com.mycompany.superherosightings.models.Hero;
import com.mycompany.superherosightings.models.Location;
import com.mycompany.superherosightings.models.Organization;
import com.mycompany.superherosightings.models.Sighting;
import com.mycompany.superherosightings.models.Superpower;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class HeroService {
    
    @Autowired
    HeroDao heroDao;
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperpowerDao superpowerDao;
    
    private final String IMAGE_DIRECTORY = "src/main/webapp/WEB-INF/photos";
    private final String IMAGE_EXTENSION = ".jpg";
    
    // SERVICE FUNCTION
    public Hero createHero(String name, boolean isHero, String descritpion, List<Superpower> superpowers){
        Hero hero = new Hero();
        hero.setName(name);
        hero.setIsHero(isHero);
        hero.setDescription(descritpion);
        hero.setSuperpowers(superpowers);
        hero.setSightings(new ArrayList<Sighting>());

        return hero;
    }
    
    public void uploadFile(String fileName, MultipartFile multipartFile) throws IOException{
        Path uploadPath = Paths.get(IMAGE_DIRECTORY);
         
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
        	        	
            Path filePath = uploadPath.resolve(fileName+IMAGE_EXTENSION);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        } 
    }
    
    public boolean isImageSet(String fileName){
        try{
            File f = new File(IMAGE_DIRECTORY + "/"+fileName+IMAGE_EXTENSION);
            if(f.exists() && !f.isDirectory()) { 
                return true;
            } else {
                return false;
            }
        } catch(Exception e){
            return false;
        }
        
    }
    
    
    // EXTERNAL DAO FUNCTIONS  
    public List<Organization> getOrganizationsForHero(Hero hero){
        return organizationDao.getOrganizationsForHero(hero);
    }
    public List<Location> getLocationsForHero(Hero hero){
        return locationDao.getLocationsForHero(hero);
    }
    // LOCAL DAO FUNCTIONS  
    public Hero getHeroById(int id){
        return heroDao.getHeroById(id);      
    }
    public List<Hero> getAllHeros(){
        return heroDao.getAllHeros();
    }
    public Hero addHero(Hero hero){
        return heroDao.addHero(hero);
    }
    public void updateHero(Hero hero){
        heroDao.updateHero(hero);
    }
    public void deleteHeroById(int id){
        heroDao.deleteHeroById(id);
    }
    
}

