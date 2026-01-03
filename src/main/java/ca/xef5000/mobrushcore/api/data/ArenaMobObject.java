package ca.xef5000.mobrushcore.api.data;

import ca.xef5000.mobrushcore.api.dto.MobDefinition;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;

public interface ArenaMobObject {

    void spawnMob(ArenaObject arena);
    void remove();
    void updateHologramText();
    NPC getNpc();
    double getHealth();
    void setHealth(double health);
    void damage(double amount);
    Player getPlayer();
    MobDefinition getMobDef();
    boolean isRemoved();
}
