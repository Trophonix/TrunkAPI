package com.trophonix.trunk.api;

import com.trophonix.trunk.api.exceptions.UnknownPlayerException;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
@SuppressWarnings("WeakerAccess")
public class UUIDStore {

    private static final Set<Profile> profiles = new HashSet<>();

    /**
     * Get a player's uuid from the uuid store using their name
     * @param name The player's name
     * @return The player's uuid
     * @throws UnknownPlayerException If the player cannot be found
     */
    public static UUID getUniqueId(String name) throws UnknownPlayerException {
        for (Profile p : profiles) {
            if (p.name.equalsIgnoreCase(name)) return p.uniqueId;
        }
        return findAndStoreUniqueId(name);
    }

    /**
     * Get a player's name from the uuid store using their uuid
     * @param uniqueId The player's uuid
     * @return The player's name
     */
    public static String getName(UUID uniqueId) {
        for (Profile p : profiles) {
            if (p.uniqueId.equals(uniqueId)) return p.name;
        }
        return findAndStoreName(uniqueId);
    }

    /**
     * Find a player's uuid and store it in the uuid store using their uuid
     * @param name The player's name
     * @return The player's name
     * @throws UnknownPlayerException If the player cannot be found
     */
    public static UUID findAndStoreUniqueId(String name) throws UnknownPlayerException {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) {
                profiles.add(new Profile(player.getUniqueId(), player.getName()));
                return player.getUniqueId();
            }
        }
        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) {
                store(player);
                return player.getUniqueId();
            }
        }
        throw new UnknownPlayerException(name);
    }

    /**
     * Find a player's name and store it in the uuid store using the uuid
     * @param uniqueId The player's uuid
     * @return The player's name
     */
    public static String findAndStoreName(UUID uniqueId) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId().equals(uniqueId)) {
                profiles.add(new Profile(player.getUniqueId(), player.getName()));
                return player.getName();
            }
        }
        return null;
    }

    /**
     * Store a player's uuid and name in the uuid store
     * @param player The player
     */
    public static void store(OfflinePlayer player) {
        profiles.add(new Profile(player.getUniqueId(), player.getName()));
    }

    static class Profile {

        public final UUID uniqueId;
        public final String name;

        Profile(UUID uniqueId, String name) {
            this.uniqueId = uniqueId;
            this.name = name;
        }

    }

}
