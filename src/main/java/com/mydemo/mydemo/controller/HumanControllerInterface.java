package com.mydemo.mydemo.controller;

import com.mydemo.mydemo.Models.Human;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface HumanControllerInterface {
    @Operation(summary = "Create a new product", description = "Add a new product to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description= "Successfully created the product"),
            @ApiResponse(responseCode = "500", description="Internal server error")
    })
    public Human getStudentByID(Integer id,  String name);
}
