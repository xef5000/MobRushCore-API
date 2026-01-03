package ca.xef5000.mobrushcore.api.data;

import ca.xef5000.mobrushcore.api.dto.MobDefinition;
import ca.xef5000.mobrushcore.api.dto.MutationDefinition;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

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
    @Nullable MutationDefinition getMutationDef();
    boolean isRemoved();
}
