package ca.xef5000.mobrushcore.api.database;

import ca.xef5000.mobrushcore.api.dto.PlacedMob;
import ca.xef5000.mobrushcore.api.dto.PlayerStats;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Database interface for MobRush plugin.
 * All operations are async and return CompletableFuture for non-blocking I/O.
 * This interface is designed to be extensible for future player data storage needs.
 */
public interface Database {

    /**
     * Initialize the database connection and create tables if needed.
     * @return CompletableFuture that completes when initialization is done
     */
    CompletableFuture<Void> initialize();

    /**
     * Shutdown the database connection gracefully.
     * This will wait for pending operations to complete.
     * @return CompletableFuture that completes when shutdown is done
     */
    CompletableFuture<Void> shutdown();

    /**
     * Check if the database is connected and operational.
     * @return true if connected
     */
    boolean isConnected();

    // =====================
    // Placed Mobs Operations
    // =====================

    /**
     * Save a placed mob to the database.
     * @param placedMob The placed mob to save
     * @return CompletableFuture with the generated ID (or existing ID if updating)
     */
    CompletableFuture<Integer> savePlacedMob(PlacedMob placedMob);

    /**
     * Remove a placed mob from the database.
     * @param id The placed mob's database ID
     * @return CompletableFuture that completes when removed
     */
    CompletableFuture<Void> removePlacedMob(int id);

    /**
     * Get all placed mobs for a specific player in a specific plot.
     * @param playerUUID The player's UUID
     * @param plotName The plot name
     * @return CompletableFuture with list of placed mobs
     */
    CompletableFuture<List<PlacedMob>> getPlacedMobs(UUID playerUUID, String plotName);

    /**
     * Get all placed mobs for a specific player across all plots.
     * @param playerUUID The player's UUID
     * @return CompletableFuture with list of placed mobs
     */
    CompletableFuture<List<PlacedMob>> getPlacedMobsByPlayer(UUID playerUUID);

    /**
     * Get all placed mobs in a specific plot (all players).
     * @param plotName The plot name
     * @return CompletableFuture with list of placed mobs
     */
    CompletableFuture<List<PlacedMob>> getPlacedMobsByPlot(String plotName);

    /**
     * Get all placed mobs from the database.
     * @return CompletableFuture with list of all placed mobs
     */
    CompletableFuture<List<PlacedMob>> getAllPlacedMobs();

    // =====================
    // Future-proof methods for player data
    // =====================

    /**
     * Execute a raw SQL query (for advanced use cases).
     * Use with caution - prefer specific methods.
     * @param query The SQL query
     * @param params Query parameters
     * @return CompletableFuture that completes when executed
     */
    CompletableFuture<Void> executeRaw(String query, Object... params);

    // =====================
    // Player Stats Operations
    // =====================

    /**
     * Get player stats from the database.
     * @param playerUUID The player's UUID
     * @return CompletableFuture with PlayerStats, or null if not found
     */
    CompletableFuture<PlayerStats> getPlayerStats(UUID playerUUID);

    /**
     * Save player stats to the database.
     * @param stats The player stats to save
     * @return CompletableFuture that completes when saved
     */
    CompletableFuture<Void> savePlayerStats(PlayerStats stats);

    /**
     * Get mob slots for a player (all plots).
     * @param playerUUID The player's UUID
     * @return CompletableFuture with map of plot name to slots
     */
    CompletableFuture<Map<String, Integer>> getPlayerMobSlots(UUID playerUUID);

    /**
     * Save mob slots for a player on a specific plot.
     * @param playerUUID The player's UUID
     * @param plotName The plot name
     * @param slots The number of slots
     * @return CompletableFuture that completes when saved
     */
    CompletableFuture<Void> savePlayerMobSlots(UUID playerUUID, String plotName, int slots);
}

