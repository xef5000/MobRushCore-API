package ca.xef5000.mobrushcore.api.data;

import ca.xef5000.mobrushcore.api.dto.MobDefinition;
import ca.xef5000.mobrushcore.api.dto.PlacedMob;
import net.citizensnpcs.api.npc.NPC;

public interface PlacedMobInstanceObject {
    PlacedMob getPlacedMob();

    NPC getNpc();

    MobDefinition getMobDefinition();
}
