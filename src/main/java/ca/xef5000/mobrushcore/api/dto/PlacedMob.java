package ca.xef5000.mobrushcore.api.dto;

import java.util.UUID;

/**
 * Represents a mob that has been placed by a player in a plot.
 * This is stored in the database and used to spawn/manage placed NPCs.
 */
public class PlacedMob {

    private int id; // Database ID, -1 if not yet saved
    private final UUID playerUUID;
    private final String plotName;
    private final String mobId;
    private final String world;
    private final double x;
    private final double y;
    private final double z;
    private final float yaw;
    private final float pitch;
    private final long placedAt;

    /**
     * Create a new PlacedMob (not yet saved to database).
     */
    public PlacedMob(UUID playerUUID, String plotName, String mobId, String world, double x, double y, double z, float yaw, float pitch) {
        this(-1, playerUUID, plotName, mobId, world, x, y, z, yaw, pitch, System.currentTimeMillis());
    }

    /**
     * Create a PlacedMob from database data.
     */
    public PlacedMob(int id, UUID playerUUID, String plotName, String mobId, String world, double x, double y, double z, float yaw, float pitch, long placedAt) {
        this.id = id;
        this.playerUUID = playerUUID;
        this.plotName = plotName;
        this.mobId = mobId;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.placedAt = placedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public String getPlotName() {
        return plotName;
    }

    public String getMobId() {
        return mobId;
    }

    public String getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public long getPlacedAt() {
        return placedAt;
    }

    @Override
    public String toString() {
        return "PlacedMob{" +
                "id=" + id +
                ", playerUUID=" + playerUUID +
                ", plotName='" + plotName + '\'' +
                ", mobId='" + mobId + '\'' +
                ", world='" + world + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

