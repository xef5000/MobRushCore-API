package ca.xef5000.mobrushcore.api.managers;

import ca.xef5000.mobrushcore.api.dto.CuboidRegion;
import ca.xef5000.mobrushcore.api.data.PlotObject;

import java.util.Map;

public interface PlotManagerAPI {
    PlotObject createPlot(String name, CuboidRegion region, int direction);
    PlotObject getPlot(String name);
    Map<String, PlotObject> getPlots();
    PlotObject getPlotAt(org.bukkit.Location location);
}
