package ca.xef5000.mobrushcore.api.dto;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Random;

public class CuboidRegion {

    private final String worldName;
    private final int x1, y1, z1;
    private final int x2, y2, z2;
    private final Random random = new Random();

    public CuboidRegion(Location loc1, Location loc2) {
        if (!loc1.getWorld().equals(loc2.getWorld())) {
            throw new IllegalArgumentException("Locations must be in the same world");
        }
        this.worldName = loc1.getWorld().getName();
        this.x1 = Math.min(loc1.getBlockX(), loc2.getBlockX());
        this.y1 = Math.min(loc1.getBlockY(), loc2.getBlockY());
        this.z1 = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        this.x2 = Math.max(loc1.getBlockX(), loc2.getBlockX());
        this.y2 = Math.max(loc1.getBlockY(), loc2.getBlockY());
        this.z2 = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
    }

    public CuboidRegion(String worldName, int x1, int y1, int z1, int x2, int y2, int z2) {
        this.worldName = worldName;
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.z1 = Math.min(z1, z2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
        this.z2 = Math.max(z1, z2);
    }

    public boolean contains(Location loc) {
        if (!loc.getWorld().getName().equals(worldName)) return false;
        return loc.getX() >= x1 && loc.getX() <= x2 + 1 &&
               loc.getY() >= y1 && loc.getY() <= y2 + 1 &&
               loc.getZ() >= z1 && loc.getZ() <= z2 + 1;
    }

    public Location getRandomLocation() {
        World world = Bukkit.getWorld(worldName);
        if (world == null) return null;
        double x = x1 + random.nextDouble() * (x2 - x1 + 1);
        double y = y1 + random.nextDouble() * (y2 - y1); // Usually we want spawn on ground, but this is generic
        double z = z1 + random.nextDouble() * (z2 - z1 + 1);
        return new Location(world, x, y, z);
    }

    public Location getCenter() {
        World world = Bukkit.getWorld(worldName);
        if (world == null) return null;
        return new Location(world, (x1 + x2 + 1) / 2.0, (y1 + y2 + 1) / 2.0, (z1 + z2 + 1) / 2.0);
    }

    public void save(ConfigurationSection section) {
        section.set("world", worldName);
        section.set("x1", x1);
        section.set("y1", y1);
        section.set("z1", z1);
        section.set("x2", x2);
        section.set("y2", y2);
        section.set("z2", z2);
    }

    public static CuboidRegion load(ConfigurationSection section) {
        if (section == null) return null;
        String world = section.getString("world");
        int x1 = section.getInt("x1");
        int y1 = section.getInt("y1");
        int z1 = section.getInt("z1");
        int x2 = section.getInt("x2");
        int y2 = section.getInt("y2");
        int z2 = section.getInt("z2");
        return new CuboidRegion(world, x1, y1, z1, x2, y2, z2);
    }

    /**
     * Returns the closest point on or within this cuboid to the given location.
     * If the location is already inside the cuboid, returns the location itself.
     */
    public Location getClosestPoint(Location loc) {
        World world = Bukkit.getWorld(worldName);
        if (world == null) return getCenter();

        // Clamp each coordinate to the cuboid bounds (exclusive of max boundary)
        double clampedX = Math.max(x1, Math.min(loc.getX(), x2));
        double clampedY = Math.max(y1, Math.min(loc.getY(), y2));
        double clampedZ = Math.max(z1, Math.min(loc.getZ(), z2));

        return new Location(world, clampedX, clampedY, clampedZ);
    }

    @Override
    public String toString() {
        return String.format("%s: (%d, %d, %d) - (%d, %d, %d)", worldName, x1, y1, z1, x2, y2, z2);
    }
}

