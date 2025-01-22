package com.example.WorkSpace.Repository;

import com.example.WorkSpace.Model.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends MongoRepository<Workspace, Long> {
}