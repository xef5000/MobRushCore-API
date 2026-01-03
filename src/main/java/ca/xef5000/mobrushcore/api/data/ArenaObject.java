package ca.xef5000.mobrushcore.api.data;

import ca.xef5000.mobrushcore.api.dto.CuboidRegion;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.Map;

public interface ArenaObject {
    String getName();

    CuboidRegion getSpawnZone();

    void setSpawnZone(CuboidRegion spawnZone);

    CuboidRegion getEndZone();

    void setEndZone(CuboidRegion endZone);

    Map<String, Double> getMobList();

    void addMob(String mobName, double percentage);

    void save(ConfigurationSection section);

    boolean isReady();

    void start();

    void stop();

    boolean isActive();

    List<ArenaMobObject> getActiveMobs();

    int getSpawnInterval();

    void setSpawnInterval(int spawnInterval);
}
