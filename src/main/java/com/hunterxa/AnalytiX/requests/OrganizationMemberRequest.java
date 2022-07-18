package com.hunterxa.AnalytiX.requests;

import com.hunterxa.AnalytiX.organization.Organization;
import com.hunterxa.AnalytiX.user.User;
import lombok.Data;

@Data
public class OrganizationMemberRequest {

    private Organization organization;
    private User member;
}
