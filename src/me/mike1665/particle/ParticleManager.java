package me.mike1665.particle;

import me.mike1665.effects.EffectManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import com.lightcraftmc.fusebox.util.UtilLocation;
import com.lightcraftmc.hub.main.Main;

public class ParticleManager
  implements Listener  
{	
	
  public static boolean hasCircleEffect(Player p)
  {
    if (CircleParticle.effect2.containsKey(p)) {
      return true;
    }
    return false;
  }

  public static void removeCircleEffect(Player p)
  {
    EffectManager.effect3.remove(p);
    UtilLocation.locationEverySecond.remove(p);
    CircleParticle.effect2.remove(p);
  }
  
  public static void registerEvents()
  {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    pm.registerEvents(new CircleParticle(), Main.getInstance());
  }


  public static enum ParticleType
  {
    Heart, Music, Flame, Water, Lava, Spark, Reddust, Enchantement, Witch, AngryVillager, Portal, Snow, Slime, Rainbow, SnowShovel, MagicCrit;
  }
}