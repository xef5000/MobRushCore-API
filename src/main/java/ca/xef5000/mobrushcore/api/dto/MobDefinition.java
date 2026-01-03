package ca.xef5000.mobrushcore.api.dto;

import org.bukkit.inventory.ItemStack;

public class MobDefinition {

    private final String id;
    private final String type;
    private final String displayName;
    private final String skin;
    private final double health;
    private final double speed;
    private final double scale;
    private final double height;
    private final ItemStack itemStack;
    private final Generation generation;

    public MobDefinition(String id, String type, String displayName, String skin, double health, double speed, double scale, double height, ItemStack itemStack, String currency, double amount) {
        this.id = id;
        this.type = type;
        this.displayName = displayName;
        this.skin = skin;
        this.health = health;
        this.speed = speed;
        this.scale = scale;
        this.height = height;
        this.itemStack = itemStack;
        this.generation = new Generation(currency, amount);
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSkin() {
        return skin;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public double getScale() {
        return scale;
    }

    public double getHeight() {
        return height;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Generation getGeneration() {
        return generation;
    }

    public record Generation(String currency, double amount) {}
}

