package ca.xef5000.mobrushcore.api.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a player's stats in the MobRush plugin.
 * All stats are stored per-player and persisted in the database.
 */
public class PlayerStats {

    private final UUID playerUUID;
    private double strengthBase;
    private double strengthMultiplier;
    private double luck;
    private double moneyMultiplier;
    private final Map<String, Integer> mobSlots; // plotName -> slots

    /**
     * Create new PlayerStats with default values.
     */
    public PlayerStats(UUID playerUUID) {
        this.playerUUID = playerUUID;
        this.strengthBase = 1.0;
        this.strengthMultiplier = 1.0;
        this.luck = 1.0;
        this.moneyMultiplier = 1.0;
        this.mobSlots = new HashMap<>();
    }

    /**
     * Create PlayerStats from database values.
     */
    public PlayerStats(UUID playerUUID, double strengthBase, double strengthMultiplier,
                       double luck, double moneyMultiplier) {
        this.playerUUID = playerUUID;
        this.strengthBase = strengthBase;
        this.strengthMultiplier = strengthMultiplier;
        this.luck = luck;
        this.moneyMultiplier = moneyMultiplier;
        this.mobSlots = new HashMap<>();
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public double getStrengthBase() {
        return strengthBase;
    }

    public void setStrengthBase(double strengthBase) {
        this.strengthBase = strengthBase;
    }

    public double getStrengthMultiplier() {
        return strengthMultiplier;
    }

    public void setStrengthMultiplier(double strengthMultiplier) {
        this.strengthMultiplier = strengthMultiplier;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public double getMoneyMultiplier() {
        return moneyMultiplier;
    }

    public void setMoneyMultiplier(double moneyMultiplier) {
        this.moneyMultiplier = moneyMultiplier;
    }

    /**
     * Get the total damage dealt by this player.
     * @return strengthBase * strengthMultiplier
     */
    public double getTotalDamage() {
        return strengthBase * strengthMultiplier;
    }

    /**
     * Get the mob slots for a specific plot.
     * @param plotName The plot name
     * @return The number of slots, or 1 (default) if not set
     */
    public int getMobSlots(String plotName) {
        return mobSlots.getOrDefault(plotName, 1);
    }

    /**
     * Set the mob slots for a specific plot.
     * @param plotName The plot name
     * @param slots The number of slots
     */
    public void setMobSlots(String plotName, int slots) {
        if (slots <= 0) {
            mobSlots.remove(plotName);
        } else {
            mobSlots.put(plotName, slots);
        }
    }

    /**
     * Get all mob slots settings.
     * @return Map of plot name to slots
     */
    public Map<String, Integer> getAllMobSlots() {
        return new HashMap<>(mobSlots);
    }

    /**
     * Load mob slots from a map (used when loading from database).
     */
    public void loadMobSlots(Map<String, Integer> slots) {
        mobSlots.clear();
        mobSlots.putAll(slots);
    }

    @Override
    public String toString() {
        return "PlayerStats{" +
                "playerUUID=" + playerUUID +
                ", strengthBase=" + strengthBase +
                ", strengthMultiplier=" + strengthMultiplier +
                ", luck=" + luck +
                ", moneyMultiplier=" + moneyMultiplier +
                ", mobSlots=" + mobSlots +
                '}';
    }
}

