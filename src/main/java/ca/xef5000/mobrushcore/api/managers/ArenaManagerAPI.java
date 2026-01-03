package ca.xef5000.mobrushcore.api.managers;

import ca.xef5000.mobrushcore.api.data.ArenaObject;

import java.util.Map;

public interface ArenaManagerAPI {
    ArenaObject getArena(String name);
    void saveArenas();
    void loadArenas();
    void stopArenas();
    Map<String, ArenaObject> getArenas();
    ArenaObject createArena(String name);
}
