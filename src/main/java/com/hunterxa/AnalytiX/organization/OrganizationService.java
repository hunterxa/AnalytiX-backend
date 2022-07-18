package com.hunterxa.AnalytiX.organization;

import com.hunterxa.AnalytiX.user.User;
import com.hunterxa.AnalytiX.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private UserRepository userRepository;

    public void addNewOrganization(Organization organization) {

        Optional<User> user = userRepository.findByEmail(organization.getCreator().getEmail());

        if (user.isEmpty()) throw new IllegalStateException("no user found with that email");

        //If user is found in database, make the persisted user the creator and add them to the members list
        organization.setCreator(user.get());
        List<User> members = new ArrayList<>();
        members.add(user.get());
        organization.setMembers(members);

        //TODO: organization.addPrivilegedMember(user);

        organizationRepository.save(organization);
    }

    @Transactional
    public void addMemberToOrganization(Organization organization, User member) {
        Optional<Organization> org = organizationRepository.findByName(organization.getName());
        if (org.isEmpty()) throw new IllegalStateException("no organization found with that name");

        Optional<User> user = userRepository.findByEmail(member.getEmail());
        if (user.isEmpty()) throw new IllegalStateException("no user found with that name");

        org.get().addMember(user.get());
    }
}
