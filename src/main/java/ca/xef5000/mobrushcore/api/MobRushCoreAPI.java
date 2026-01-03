package ca.xef5000.mobrushcore.api;

import ca.xef5000.mobrushcore.api.managers.*;

public interface MobRushCoreAPI {

    ArenaManagerAPI getArenaManager();

    PlacedMobManagerAPI getPlacedMobManager();

    PlotManagerAPI getPlotManager();

    MobManagerAPI getMobManager();

    StatsManagerAPI getStatsManager();
}
