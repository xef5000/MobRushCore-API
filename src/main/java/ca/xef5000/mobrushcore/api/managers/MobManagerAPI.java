package ca.xef5000.mobrushcore.api.managers;

import ca.xef5000.mobrushcore.api.dto.MobDefinition;

import java.util.Map;

public interface MobManagerAPI {

    MobDefinition getMob(String name);
    Map<String, MobDefinition> getMobs();
}
