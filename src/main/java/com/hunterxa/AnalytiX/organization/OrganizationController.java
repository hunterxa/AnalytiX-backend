package com.hunterxa.AnalytiX.organization;

import com.hunterxa.AnalytiX.requests.OrganizationMemberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public void addNewOrganization(@RequestBody Organization organization) {
        organizationService.addNewOrganization(organization);
    }

    @PutMapping("/addmember")
    public void addMemberToOrganization(@RequestBody OrganizationMemberRequest request) {
        organizationService.addMemberToOrganization(
                request.getOrganization(),
                request.getMember()
        );
    }
}
