package com.microsoft.azure.helium.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * SystemController
 */
@Api(tags="System")
@RestController
public class SystemController {

    @RequestMapping(value = "/api/healthz", method = RequestMethod.GET)
    @ApiOperation(value = "Health probe", notes = "Tells external services if the service is running")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully reached healthcheck endpoint") })

    public ResponseEntity<String> healthz() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}