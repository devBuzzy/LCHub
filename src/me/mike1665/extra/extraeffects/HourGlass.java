package me.mike1665.extra.extraeffects;

import me.mike1665.effects.EffectManager;
import me.mike1665.extra.ExtraManager;
import me.mike1665.particles18.ParticleLib18;
import me.mike1665.update.UpdateType;
import me.mike1665.update.event.UpdateEvent;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import com.lightcraftmc.fusebox.util.MathUtils;
import com.lightcraftmc.fusebox.util.UtilVector;

public class HourGlass
  implements Listener
{
  private int particles = 120;
  private int particlesPerIteration = 8;
  private float size = 1.0F;
  private float xFactor = 1.0F;
  private float yFactor = 0.6F;
  private float zFactor = 1.0F;
  private float yOffset = 0.6F;
  private double xRotation;
  private double yRotation;
  private double zRotation = 0.0D;
  private int step;

  @EventHandler
  public void LocationUpdater(UpdateEvent event)
  {
    if (event.getType() == UpdateType.TICK)
    {
      for (Player p : EffectManager.effect3.keySet())
      {
        if (EffectManager.getEffect(p) == EffectManager.EffectType.HourGlass)
        {
          if (p.isValid())
          {
            if (ExtraManager.isMoving(p))
            {
              Location location = p.getLocation();

              Vector vector = new Vector();

              for (int i = 0; i < this.particlesPerIteration; i++) {
                this.step += 1;

                float t = 3.141593F / this.particles * this.step;
                float r = MathUtils.sin(t * 2.718282F * this.particlesPerIteration / this.particles) * this.size;
                float s = r * 3.141593F * t;

                vector.setX(this.xFactor * r * -MathUtils.cos(s));
                vector.setZ(this.zFactor * r * -MathUtils.sin(s));
                vector.setY(this.yFactor * r + this.yOffset + 2.0F);

                UtilVector.rotateVector(vector, this.xRotation, this.yRotation, this.zRotation);
     		    ParticleLib18 ench = new ParticleLib18(me.mike1665.particles18.ParticleLib18.ParticleType.ENCHANTMENT_TABLE, 0.0D, 1, 0.0D);
     		    ench.sendToLocation(location.add(vector));

                location.subtract(vector);
              }

            }
            else if (!p.isInsideVehicle()) {
   		   	  ParticleLib18 ench2 = new ParticleLib18(me.mike1665.particles18.ParticleLib18.ParticleType.ENCHANTMENT_TABLE, 0.1000000014901161D, 4, 0.300000011920929D);
   		   	  ench2.sendToLocation(p.getLocation().add(0.0D, 1.0D, 0.0D));
            }
          }
        }
      }
    }
  }
}