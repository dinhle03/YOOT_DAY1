package com.example.yootday1.service;

import com.example.yootday1.common.exception.BadRequestException;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.parent.ParentDashboardResponse;

public interface ParentPortalService {
    ParentDashboardResponse getDashboard(String username) throws BadRequestException, NotFoundException;
}
