package me.shakeforprotein.mirv;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class MIRV extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    @EventHandler
    public void onArrowFireEvent(ProjectileLaunchEvent e) {
        if (e.getEntity().getName().equalsIgnoreCase("Arrow")) {
            if (e.getEntity().getShooter() instanceof Player) {
                Player p = (Player) e.getEntity().getShooter();
                if (p.hasPermission("mirv.launch")) {
                    if (p.getInventory().getItemInOffHand().getType() == Material.TNT) {
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                            public void run() {
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT).setVelocity((e.getEntity().getVelocity().subtract(new Vector(2, 0, 2))).normalize());
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT).setVelocity((e.getEntity().getVelocity().subtract(new Vector(30, 0, 30))).normalize());
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT).setVelocity((e.getEntity().getVelocity().subtract(new Vector(60, 0, 2))).normalize());
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT).setVelocity((e.getEntity().getVelocity().add(new Vector(2, 0, 60))).normalize());
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT).setVelocity((e.getEntity().getVelocity().add(new Vector(25, 0, 25))).normalize());
                                e.getEntity().remove();
                            }
                        }, 25L);
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                            public void run() {
                                e.getEntity().remove();
                            }
                        }, 30L);
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.RABBIT_FOOT) {
                        e.getEntity().setBounce(true);
                    }
                }
            }
        }
    }

    @EventHandler
    private void onArrowHit(ProjectileHitEvent e) {
        if (e.getEntity().getName().equalsIgnoreCase("Arrow")) {
            if (e.getEntity().getShooter() instanceof Player) {
                Player p = (Player) e.getEntity().getShooter();
                if (p.hasPermission("mirv.launch")) {
                    if (p.getInventory().getItemInOffHand().getType() == Material.BEDROCK) {
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                            public void run() {
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
                            }
                        }, 30L);
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.ANVIL) {
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                            public void run() {
                                e.getEntity().setGravity(true);
                            }
                        }, 10L);
                    }

                    if (p.getInventory().getItemInOffHand().getType() == Material.RABBIT_FOOT) {
                        e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
                    }

                    if (p.getInventory().getItemInOffHand().getType() == Material.SLIME_BALL) {
                        if(e.getEntity(). getNearbyEntities(0,0,0).toArray()[0] instanceof Entity)

                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                                public void run() {
                                e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
                            }
                        }, 15L);
                    }
                }
                if (p.getInventory().getItemInOffHand().getType() == Material.TORCH && p.hasPermission("mirv.torch")) {
                    if (e.getHitBlock() != null){
                    Location hitBlock = e.getHitBlock().getLocation();
                    Location torchPos = hitBlock.add(0,1,0);
                    if(torchPos.getBlock().getType() == Material.AIR){
                        p.getInventory().getItemInOffHand().setAmount(p.getInventory().getItemInOffHand().getAmount() - 1);
                        ((Player) e.getEntity().getShooter()).
                        torchPos.getBlock()
                                .setType(Material.TORCH);
                            }
                        }
                    }
                }
            }
        }
    }
}

