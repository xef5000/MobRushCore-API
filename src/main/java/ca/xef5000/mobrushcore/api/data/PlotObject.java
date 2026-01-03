package ca.xef5000.mobrushcore.api.data;

import ca.xef5000.mobrushcore.api.dto.CuboidRegion;
import org.bukkit.configuration.ConfigurationSection;

public interface PlotObject {
    String getName();
    CuboidRegion getRegion();
    void setRegion(CuboidRegion region);
    int getDirection();
    void setDirection(int direction);
    void save(ConfigurationSection section);
    boolean isReady();
}
