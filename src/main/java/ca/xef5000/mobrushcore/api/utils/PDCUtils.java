package ca.xef5000.mobrushcore.api.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public final class PDCUtils {
    public static final String NAMESPACE = "mobrush";
    public static final String KEY_MOB = "mob";
    public static final String KEY_MUTATION = "mutation";

    public static final NamespacedKey MOB_KEY = new NamespacedKey(NAMESPACE, KEY_MOB);
    public static final NamespacedKey MUTATION_KEY = new NamespacedKey(NAMESPACE, KEY_MUTATION);

    public static ItemStack associateMob(ItemStack item, String mobId, @Nullable String mutationId) {
        if (item == null || !item.hasItemMeta()) {
            return item; // Safety check
        }

        ItemMeta meta = item.getItemMeta();

        meta.getPersistentDataContainer().set(MOB_KEY, PersistentDataType.STRING, mobId);
        if (mutationId != null) {
            meta.getPersistentDataContainer().set(MUTATION_KEY, PersistentDataType.STRING, mutationId);
        }

        item.setItemMeta(meta);

        return item;
    }

    public static boolean isAssociatedMob(ItemStack item) {
        if (item == null || !item.hasItemMeta()) {
            return false; // Safety check
        }

        ItemMeta meta = item.getItemMeta();

        return meta.getPersistentDataContainer().has(MOB_KEY, PersistentDataType.STRING);
    }

    public static String getAssociatedMob(ItemStack item) {
        if (!isAssociatedMob(item)) {
            return null; // Safety check
        }

        ItemMeta meta = item.getItemMeta();

        return meta.getPersistentDataContainer().get(MOB_KEY, PersistentDataType.STRING);
    }

    public static String getAssociatedMutation(ItemStack item) {
        if (!isAssociatedMob(item)) {
            return null; // Safety check
        }

        ItemMeta meta = item.getItemMeta();

        return meta.getPersistentDataContainer().get(MUTATION_KEY, PersistentDataType.STRING);
    }
}
