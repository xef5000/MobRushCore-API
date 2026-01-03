package ca.xef5000.mobrushcore.api;

import ca.xef5000.mobrushcore.api.managers.ArenaManagerAPI;
import ca.xef5000.mobrushcore.api.managers.MobManagerAPI;
import ca.xef5000.mobrushcore.api.managers.PlacedMobManagerAPI;
import ca.xef5000.mobrushcore.api.managers.PlotManagerAPI;

public interface MobRushCoreAPI {

    ArenaManagerAPI getArenaManager();

    PlacedMobManagerAPI getPlacedMobManager();

    PlotManagerAPI getPlotManager();

    MobManagerAPI getMobManager();
}
