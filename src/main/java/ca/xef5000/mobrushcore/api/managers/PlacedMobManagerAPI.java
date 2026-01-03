package ca.xef5000.mobrushcore.api.managers;

import ca.xef5000.mobrushcore.api.data.PlacedMobInstanceObject;
import ca.xef5000.mobrushcore.api.dto.PlacedMob;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface PlacedMobManagerAPI {
    /**
     * Place a new mob for a player at a location.
     * @param player The player placing the mob
     * @param plotName The plot name
     * @param mobId The mob definition ID
     * @param mutationId The mutation definition ID (nullable)
     * @param location The location to place at
     * @return The created PlacedMob, or null if failed (e.g., no slots available)
     */
    PlacedMob placeMob(Player player, String plotName, String mobId, @Nullable String mutationId, Location location);

    /**
     * Count how many mobs a player has placed in a specific plot.
     */
    int countPlayerMobsInPlot(UUID playerUUID, String plotName);

    /**
     * Check if a player has available slots in a plot.
     */
    boolean hasAvailableSlots(UUID playerUUID, String plotName);

    /**
     * Remove a placed mob by its database ID.
     * @param id The database ID
     */
    void removePlacedMob(int id);

    /**
     * Get all placed mob instances for a player.
     */
    List<PlacedMobInstanceObject> getPlayerInstances(UUID playerUUID);

    /**
     * Get a placed mob instance by its NPC.
     */
    PlacedMobInstanceObject getInstanceByNpc(NPC npc);

    /**
     * Get a placed mob instance by database ID.
     */
    PlacedMobInstanceObject getInstance(int id);

    /**
     * Get all instances.
     */
    Collection<PlacedMobInstanceObject> getAllInstances();
}
