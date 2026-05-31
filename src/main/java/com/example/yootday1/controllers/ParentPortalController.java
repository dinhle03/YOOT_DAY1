package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.BadRequestException;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.parent.ParentDashboardResponse;
import com.example.yootday1.service.ParentPortalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/parent")
@RequiredArgsConstructor
public class ParentPortalController {

    private final ParentPortalService parentPortalService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('PARENT')")
    public ApiResponse<ParentDashboardResponse> dashboard(Principal principal) throws BadRequestException, NotFoundException {
        return ApiResponse.success(parentPortalService.getDashboard(principal.getName()));
    }

}
