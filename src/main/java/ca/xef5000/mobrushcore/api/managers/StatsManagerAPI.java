package ca.xef5000.mobrushcore.api.managers;

import ca.xef5000.mobrushcore.api.dto.PlayerStats;

import java.util.UUID;
import java.util.logging.Level;

public interface StatsManagerAPI {

    /**
     * Get player stats from cache, loading if necessary.
     */
    PlayerStats getStats(UUID playerUUID);

    /**
     * Get player stats from cache, or null if not loaded.
     */
    PlayerStats getStatsIfLoaded(UUID playerUUID);

    void setStrengthBase(UUID playerUUID, double value);

    void addStrengthBase(UUID playerUUID, double value);

    void setStrengthMultiplier(UUID playerUUID, double value);

    void addStrengthMultiplier(UUID playerUUID, double value);

    void setLuck(UUID playerUUID, double value);

    void addLuck(UUID playerUUID, double value);

    void setMoneyMultiplier(UUID playerUUID, double value);

    void addMoneyMultiplier(UUID playerUUID, double value);

    void setMobSlots(UUID playerUUID, String plotName, int value);

    void addMobSlots(UUID playerUUID, String plotName, int value);
}
