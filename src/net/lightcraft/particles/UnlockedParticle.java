package net.lightcraft.particles;

import me.mike1665.particles18.ParticleLib18.ParticleType;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Listener;

import com.lightcraftmc.hub.main.Main;

public class UnlockedParticle implements Listener{
	
	private static Main plugin;
	
	public static void initialize(){
		UnlockedParticle.plugin = Main.getInstance();
	}
	
	public static boolean hasUnlockedParticle(OfflinePlayer p, ParticleType m) {
		return plugin.getConfig().getBoolean(p.getPlayer().getUniqueId() + "." + m.toString() + "_Particle");
	}
	
	public static void unlockParticle(OfflinePlayer p, ParticleType m) {
		plugin.getConfig().set(p.getPlayer().getUniqueId() + "." + m.toString() + "_Particle", true);
		plugin.saveConfig();
	}

}
