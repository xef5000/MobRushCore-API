package ca.xef5000.mobrushcore.api.dto;

/**
 * Represents a mutation that can be applied to a mob.
 * - name: Unique identifier for the mutation
 * - displayName: Display name for the mutation
 * - multiplier-health: Multiplier for the mob's health
 * - multiplier-generation: Multiplier for the mob's generation amount
 * - chance: Chance of the mutation occurring
 */
public class MutationDefinition {
    private final String id;
    private final String displayName;
    private final double multiplierHealth;
    private final double multiplierGeneration;
    private final double chance;

    public MutationDefinition(String id, String displayName, double multiplierHealth, double multiplierGeneration, double chance) {
        this.id = id;
        this.displayName = displayName;
        this.multiplierHealth = multiplierHealth;
        this.multiplierGeneration = multiplierGeneration;
        this.chance = chance;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getMultiplierHealth() {
        return multiplierHealth;
    }

    public double getMultiplierGeneration() {
        return multiplierGeneration;
    }

    public double getChance() {
        return chance;
    }
}
