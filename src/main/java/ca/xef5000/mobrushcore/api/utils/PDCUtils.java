package ca.xef5000.mobrushcore.api.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public final class PDCUtils {
    public static final String NAMESPACE = "mobrush";
    public static final String KEY_MOB = "mob";

    public static final NamespacedKey MOB_KEY = new NamespacedKey(NAMESPACE, KEY_MOB);

    public static ItemStack associateMob(ItemStack item, String mobId) {
        if (item == null || !item.hasItemMeta()) {
            return item; // Safety check
        }

        ItemMeta meta = item.getItemMeta();

        meta.getPersistentDataContainer().set(MOB_KEY, PersistentDataType.STRING, mobId);

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
        if (isAssociatedMob(item)) {
            return null; // Safety check
        }

        ItemMeta meta = item.getItemMeta();

        return meta.getPersistentDataContainer().get(MOB_KEY, PersistentDataType.STRING);
    }
}
