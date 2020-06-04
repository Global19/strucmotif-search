package org.rcsb.strucmotif;

import org.rcsb.strucmotif.domain.result.MotifSearchResult;
import org.rcsb.strucmotif.domain.selection.AuthorSelection;

import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        // the entry point for all things motif search - #newQuery() starts building a new query
        MotifSearchResult simple = MotifSearch.newQuery()
                // several ways can be used to define the query motif - specify a PDB entry id
                .defineByPdbIdAndSelection("4cha",
                        // and a collection of sequence positions to extract residues to use as motif
                        Set.of(new AuthorSelection("B", 1, 57), // H
                               new AuthorSelection("B", 1, 102), // D
                               new AuthorSelection("C", 1, 195))) // S
                // parameters are considered mandatory arguments
                .buildParameters()
                // retrieve container with complete query
                .buildQuery()
                // execute query
                .run();
    }
}