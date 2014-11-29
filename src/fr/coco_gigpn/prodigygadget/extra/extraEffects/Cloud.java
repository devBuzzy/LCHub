package fr.coco_gigpn.prodigygadget.extra.extraEffects;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.coco_gigpn.prodigygadget.effect.EffectManager;
import fr.coco_gigpn.prodigygadget.effect.EffectManager.EffectType;
import fr.coco_gigpn.prodigygadget.updater.UpdateType;
import fr.coco_gigpn.prodigygadget.updater.event.UpdateEvent;
import fr.coco_gigpn.prodigygadget.util.UtilLocation;
import fr.coco_gigpn.prodigygadget.util.UtilMath;
import fr.coco_gigpn.prodigygadget.util.UtilParticle;
import fr.coco_gigpn.prodigygadget.util.UtilParticle.Particle;

public class Cloud implements Listener {

	@EventHandler
	public void LocationUpdater(UpdateEvent event) {
		if (event.getType() == UpdateType.TICK) {

			for (Player p : EffectManager.effect.keySet()) {

				if (EffectManager.getEffect(p) == EffectType.Cloud) {

					if (p.isValid()) {


						Location loc = p.getLocation();
						if (UtilLocation.locationEvery2Second.containsKey(p)) {
							loc = UtilLocation.locationEvery2Second.get(p);
						}

						Location l = new Location(p.getWorld(), loc.getX() , loc.getY() , loc.getZ());
						l.setY(p.getLocation().getY() + 3.7f);
						UtilParticle.sendParticleToLocation(l.add(UtilMath.randomRangeFloat(-0.4f, 0.4f) , 0 , UtilMath.randomRangeFloat(-0.5f, 0.5f)), Particle.DRIP_WATER, 0, 0, 0, 0, 1);
						UtilParticle.sendParticleToLocation(l.add(UtilMath.randomRangeFloat(-0.5f, 0.5f) , 0 , UtilMath.randomRangeFloat(-0.5f, 0.5f)), Particle.CLOUD, 0, 0, 0, 0, 3);
						UtilParticle.sendParticleToLocation(l.add(UtilMath.randomRangeFloat(-0.5f, 0.5f) , 0 , UtilMath.randomRangeFloat(-0.5f, 0.5f)), Particle.CLOUD, 0, 0, 0, 0, 3);

						l.subtract(l);



					}

				}
			}

		}
	}


}