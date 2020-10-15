package org.rcsb.strucmotif;

import org.rcsb.strucmotif.align.AlignmentService;
import org.rcsb.strucmotif.domain.query.QueryBuilder;
import org.rcsb.strucmotif.io.StructureDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
@EntityScan("org.rcsb.strucmotif")
public class MotifSearchApplication {
    static QueryBuilder queryBuilder;
    static AlignmentService alignmentService;
    static StructureDataProvider structureDataProvider;

    public static void main(String[] args) {
        SpringApplication.run(MotifSearchApplication.class, args);
    }

    @Autowired
    public MotifSearchApplication(QueryBuilder queryBuilder, AlignmentService alignmentService, StructureDataProvider structureDataProvider) {
        MotifSearchApplication.queryBuilder = queryBuilder;
        MotifSearchApplication.alignmentService = alignmentService;
        MotifSearchApplication.structureDataProvider = structureDataProvider;
    }
}
