/*
 * Copyright (C) 2001-2016 Food and Agriculture Organization of the
 * United Nations (FAO-UN), United Nations World Food Programme (WFP)
 * and United Nations Environment Programme (UNEP)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 *
 * Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
 * Rome - Italy. email: geonetwork@osgeo.org
 */

package org.fao.geonet.api.status;

import org.fao.geonet.api.API;
import org.fao.geonet.api.ApiUtils;
import org.fao.geonet.domain.StatusValue;
import org.fao.geonet.repository.StatusValueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jeeves.server.context.ServiceContext;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = {
    "/api/status",
    "/api/" + API.VERSION_0_1 +
        "/status"
})
@Api(value = "status",
    tags = "status",
    description = "Workflow status operations")
@Controller("status")
public class StatusApi {

    @ApiOperation(
        value = "Get status",
        notes = "",
        nickname = "getStatus")
    @RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<StatusValue> getStatus(HttpServletRequest request) throws Exception {
        ServiceContext context = ApiUtils.createServiceContext(request);
        return context.getBean(StatusValueRepository.class).findAll();
    }
}
