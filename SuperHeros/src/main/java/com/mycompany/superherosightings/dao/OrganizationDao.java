
package com.mycompany.superherosightings.dao;

import com.mycompany.superherosightings.models.Hero;
import com.mycompany.superherosightings.models.Organization;
import java.util.List;

public interface OrganizationDao {
    
    Organization getOrganizationById(int id);
    List<Organization> getAllOrganizations();
    Organization addOrganization(Organization organization);
    void updateOrganization(Organization organization);
    void deleteOrganizationById(int id);
    
    List<Organization> getOrganizationsForHero(Hero hero);
}
