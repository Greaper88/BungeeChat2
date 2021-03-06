package dev.aura.bungeechat.hook.metrics;

import dev.aura.bungeechat.module.BungeecordModuleManager;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bstats.bungeecord.Metrics.SimpleBarChart;

public class ModuleData extends SimpleBarChart {
  public ModuleData() {
    super("modules", ModuleData::getMap);
  }

  public static Map<String, Integer> getMap() {
    Map<String, Integer> sortedMap = new LinkedHashMap<>();

    BungeecordModuleManager.getLocalModules().stream()
        .forEach(module -> sortedMap.put(module.getName(), module.isEnabled() ? 1 : 0));

    sortedMap.put("Servers", 1);

    return sortedMap;
  }
}
