package ca.xef5000.mobrushcore.api.managers;

import ca.xef5000.mobrushcore.api.dto.MutationDefinition;

import java.util.Map;

public interface MutationManagerAPI {

    MutationDefinition getMutation(String name);
    Map<String, MutationDefinition> getMutations();
    MutationDefinition pickRandomMutation();
}
