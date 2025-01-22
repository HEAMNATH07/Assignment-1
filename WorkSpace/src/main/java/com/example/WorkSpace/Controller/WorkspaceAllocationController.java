package com.example.WorkSpace.Controller;


import com.example.WorkSpace.Model.Workspace;
import com.example.WorkSpace.Response.MessageResponse;
import com.example.WorkSpace.Service.WorkspaceService;
import com.example.WorkSpace.Service.WorkspaceServiceAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/workspaces")
public class WorkspaceAllocationController {

    @Autowired
    private WorkspaceServiceAllocation workspaceServiceAllocation;

    @Autowired
    private WorkspaceService workspaceService;

    // Create a new workspace
    @PostMapping("/admin")
    public ResponseEntity<Workspace> createWorkspace(@RequestBody Workspace workspace) {
        return workspaceService.createWorkspace(workspace);
    }

    // Get a workspace by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Workspace> getWorkspaceById(@PathVariable Long id) {
        return workspaceService.getWorkspaceById(id);
    }

    // Get all workspaces
    @GetMapping
    public ResponseEntity<List<Workspace>> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    // Update a workspace
    @PutMapping("/admin/{id}")
    public ResponseEntity<Workspace> updateWorkspace(@PathVariable Long id, @RequestBody Workspace workspace) {
        return workspaceService.updateWorkspace(id, workspace);
    }

    // Delete a workspace by its ID
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable Long id) {
        return workspaceService.deleteWorkspace(id);
    }


    // Allocate Workspace
    @PostMapping("/allocate/{id}")
    public ResponseEntity<MessageResponse> allocateWorkspace(@PathVariable Long id) {
        return (ResponseEntity<MessageResponse>) workspaceServiceAllocation.allocateWorkspace(id);
    }

    // Release Workspace
    @PostMapping("/release/{id}")
    public ResponseEntity<MessageResponse> releaseWorkspace(@PathVariable Long id) {
        return (ResponseEntity<MessageResponse>) workspaceServiceAllocation.releaseWorkspace(id);
    }
}
