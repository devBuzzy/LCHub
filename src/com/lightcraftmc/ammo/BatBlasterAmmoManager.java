package com.lightcraftmc.ammo;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Listener;

import com.lightcraftmc.coin.Multiplier;
import com.lightcraftmc.hub.main.Main;

public class BatBlasterAmmoManager implements Listener {
	
	private static Main plugin;
	
	public static void initialize(){
		BatBlasterAmmoManager.plugin = Main.getInstance();
	}
	
	public static void giveBatAmmo(OfflinePlayer p, int i) {
		i = i * Multiplier.coin(p);
		plugin.getConfig().set(p.getUniqueId() + ".BatBlasterAmmo",
				plugin.getConfig().getInt(p.getUniqueId() + ".BatBlasterAmmo", 0) + i);
		plugin.saveFile();
	}

	public static void takeBatAmmo(OfflinePlayer p, int i) {
		i = i * Multiplier.coin(p);
		plugin.getConfig().set(p.getUniqueId() + ".BatBlasterAmmo",
				plugin.getConfig().getInt(p.getUniqueId() + ".BatBlasterAmmo", 0) - i);
		plugin.saveFile();
	}

	public static boolean hasEnoughBatAmmo(OfflinePlayer p, int i) {
		i = i * Multiplier.coin(p);
		if (plugin.getConfig().getInt(p.getUniqueId() + ".BatBlasterAmmo") >= i)
			return true;
		return false;
	}
	public static int balaceBatAmmo(OfflinePlayer p) {
		int a;
		try {
			a = plugin.getConfig().getInt(p.getUniqueId() + ".BatBlasterAmmo");
		}catch(Exception exc) {
			a = 0;
		}
		return a;
	}
}