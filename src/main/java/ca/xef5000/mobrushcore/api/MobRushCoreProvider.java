package ca.xef5000.mobrushcore.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public final class MobRushCoreProvider {

    private MobRushCoreProvider() {}

    public static MobRushCoreAPI get() {
        RegisteredServiceProvider<MobRushCoreAPI> rsp =
                Bukkit.getServicesManager().getRegistration(MobRushCoreAPI.class);

        return rsp != null ? rsp.getProvider() : null;
    }
}

