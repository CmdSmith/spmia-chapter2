package com.thoughtmechanix.licenses.controllers;

import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

// @RestController 告诉Spring Boot是一个基于REST的服务，它将自动序列化/反序列化服务请求/响应到JSON
@RestController
// 使用 v1/organizations/{organizationId}/licenses 作为前缀公开所有的HTTP端点
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
    @Autowired
    private LicenseService licenseService;

    // 使用值创建一个GET端点 v1/organizations/{organizationId}/licenses/{licenseId}
    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    public License getLicenses( // 从 URL映射两个参数（organizationId和licenseId）到方法参数
                                @PathVariable("organizationId") String organizationId,
                                @PathVariable("licenseId") String licenseId) {

        //return licenseService.getLicense(licenseId);
        return new License()
            .withId(licenseId)
            .withOrganizationId(organizationId)
            .withProductName("Teleco")
            .withLicenseType("Seat");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.PUT)
    public String updateLicenses( @PathVariable("licenseId") String licenseId) {
        return String.format("This is the put");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.POST)
    public String saveLicenses( @PathVariable("licenseId") String licenseId) {
        return String.format("This is the post");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteLicenses( @PathVariable("licenseId") String licenseId) {
        return String.format("This is the Delete");
    }
}
