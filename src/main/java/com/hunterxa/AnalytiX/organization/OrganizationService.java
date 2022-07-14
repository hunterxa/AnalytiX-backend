package com.hunterxa.AnalytiX.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public void addNewOrganization(Organization organization) {
        organizationRepository.save(organization);
    }
}
