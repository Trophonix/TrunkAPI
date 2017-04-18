package com.trophonix.trunk.api.chat;

import com.trophonix.trunk.api.UUIDStore;
import com.trophonix.trunk.api.TrunkAPI;
import com.trophonix.trunk.api.exceptions.APIRegisterException;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import com.trophonix.trunk.api.exceptions.UnknownPlayerException;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.UUID;

/**
 * Created by Lucas on 4/12/17.
 */
@SuppressWarnings("WeakerAccess")
public abstract class TrunkChat extends TrunkAPI {

    private final Plugin plugin;
    private final TrunkPermissions perms;

    /**
     * TrunkChat constructor
     * @param plugin The registering plugin
     * @param perms Permissions API to use for some methods
     */
    public TrunkChat(Plugin plugin, TrunkPermissions perms) {
        this.plugin = plugin;
        this.perms = perms;
    }

    /**
     * TrunkChat constructor
     * @param plugin The registering plugin
     * @throws APIRegisterException If a Permissions API cannot be found
     */
    public TrunkChat(Plugin plugin) throws APIRegisterException {
        this.plugin = plugin;
        RegisteredServiceProvider<TrunkPermissions> rsp = Bukkit.getServer().getServicesManager().getRegistration(TrunkPermissions.class);
        if (rsp != null && rsp.getProvider() != null) {
            perms = rsp.getProvider();
        } else {
            throw new APIRegisterException("Couldn't find a permissions API! Make sure one is registered first.");
        }
    }

    /**
     * @return The registering plugin
     */
    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Get a player's prefix
     * @param uniqueId The player's uuid
     * @return The player's prefix
     */
    public abstract String getPrefix(UUID uniqueId);

    /**
     * Get a player's prefix
     * @param player The player
     * @return The player's prefix
     * @see TrunkChat#getPrefix(UUID) Redirects to this method by default
     */
    public String getPrefix(OfflinePlayer player) {
        return getPrefix(player.getUniqueId());
    }

    /**
     * Get a player's prefix
     * @param name The player's name
     * @return The player's prefix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#getPrefix(UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public String getPrefix(String name) throws UnknownPlayerException {
        return getPrefix(UUIDStore.getUniqueId(name));
    }

    /**
     * Get a player's prefix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's prefix
     * @see TrunkChat#getPrefix(UUID) Redirects to this method by default
     */
    public String getPrefix(String world, UUID uniqueId) {
        return getPrefix(uniqueId);
    }

    /**
     * Get a player's prefix in a specific world
     * @param world The world
     * @param player The player
     * @return The player's prefix
     * @see TrunkChat#getPrefix(String, UUID) Redirects to this method by default
     */
    public String getPrefix(String world, OfflinePlayer player) {
        return getPrefix(world, player.getUniqueId());
    }

    /**
     * Get a player's prefix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's prefix
     * @see TrunkChat#getPrefix(String, UUID) Redirects to this method by default
     */
    public String getPrefix(World world, UUID uniqueId) {
        return getPrefix(world.getName(), uniqueId);
    }

    /**
     * Get a player's prefix in a specific world
     * @param world The world
     * @param player The player
     * @return The player's prefix
     * @see TrunkChat#getPrefix(String, UUID) Redirects to this method by default
     */
    public String getPrefix(World world, OfflinePlayer player) {
        return getPrefix(world.getName(), player.getUniqueId());
    }

    /**
     * Get a player's prefix in a specific world
     * @param world The world
     * @param name The player's name
     * @return The player's prefix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#getPrefix(String, UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public String getPrefix(String world, String name) throws UnknownPlayerException {
        return getPrefix(world, UUIDStore.getUniqueId(name));
    }

    /**
     * Set a player's prefix
     * @param uniqueId The player's uuid
     * @param prefix The new prefix
     */
    public abstract void setPrefix(UUID uniqueId, String prefix);

    /**
     * Set a player's prefix
     * @param player The player
     * @param prefix The new prefix
     * @see TrunkChat#setPrefix(UUID, String) Redirects to this method by default
     */
    public void setPrefix(OfflinePlayer player, String prefix) {
        setPrefix(player.getUniqueId(), prefix);
    }

    /**
     * Set a player's prefix
     * @param name The player's name
     * @param prefix The new prefix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#setPrefix(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public void setPrefix(String name, String prefix) throws UnknownPlayerException {
        setPrefix(UUIDStore.getUniqueId(name), prefix);
    }

    /**
     * Set player's prefix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param prefix The new prefix
     * @see TrunkChat#setPrefix(UUID, String) Redirects to this method by default
     */
    public void setPrefix(String world, UUID uniqueId, String prefix) {
        setPrefix(uniqueId, prefix);
    }

    /**
     * Set player's prefix in a specific world
     * @param world The world
     * @param player The player
     * @param prefix The new prefix
     * @see TrunkChat#setPrefix(String, UUID, String) Redirects to this method by default
     */
    public void setPrefix(String world, OfflinePlayer player, String prefix) {
        setPrefix(world, player.getUniqueId(), prefix);
    }

    /**
     * Set player's prefix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param prefix The new prefix
     * @see TrunkChat#setPrefix(String, UUID, String) Redirects to this method by default
     */
    public void setPrefix(World world, UUID uniqueId, String prefix) {
        setPrefix(world.getName(), uniqueId, prefix);
    }

    /**
     * Set player's prefix in a specific world
     * @param world The world
     * @param player The player
     * @param prefix The new prefix
     * @see TrunkChat#setPrefix(String, UUID, String) Redirects to this method by default
     */
    public void setPrefix(World world, OfflinePlayer player, String prefix) {
        setPrefix(world.getName(), player.getUniqueId(), prefix);
    }

    /**
     * Set player's prefix in a specific world
     * @param world The world
     * @param name The player's name
     * @param prefix The new prefix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#setPrefix(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public void setPrefix(String world, String name, String prefix) throws UnknownPlayerException {
        setPrefix(world, UUIDStore.getUniqueId(name), prefix);
    }

    /**
     * Get a player's suffix
     * @param uniqueId The player's uuid
     * @return The player's prefix
     */
    public abstract String getSuffix(UUID uniqueId);

    /**
     * Get a player's suffix
     * @param player The player
     * @return The player's prefix
     * @see TrunkChat#getSuffix(UUID) Redirects to this method by default
     */
    public String getSuffix(OfflinePlayer player) {
        return getSuffix(player.getUniqueId());
    }

    /**
     * Get a player's suffix
     * @param name The player's name
     * @return The player's prefix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#getSuffix(UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public String getSuffix(String name) throws UnknownPlayerException {
        return getSuffix(UUIDStore.getUniqueId(name));
    }

    /**
     * Get a player's suffix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's suffix
     * @see TrunkChat#getSuffix(UUID) Redirects to this method by default
     */
    public String getSuffix(String world, UUID uniqueId) {
        return getSuffix(uniqueId);
    }

    /**
     * Get a player's suffix in a specific world
     * @param world The world
     * @param player The player
     * @return The player's suffix
     * @see TrunkChat#getSuffix(String, UUID) Redirects to this method by default
     */
    public String getSuffix(String world, OfflinePlayer player) {
        return getSuffix(world, player.getUniqueId());
    }

    /**
     * Get a player's suffix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's suffix
     * @see TrunkChat#getSuffix(String, UUID) Redirects to this method by default
     */
    public String getSuffix(World world, UUID uniqueId) {
        return getSuffix(world.getName(), uniqueId);
    }

    /**
     * Get a player's suffix in a specific world
     * @param world The world
     * @param player The player
     * @return The player's suffix
     * @see TrunkChat#getSuffix(String, UUID) Redirects to this method by default
     */
    public String getSuffix(World world, OfflinePlayer player) {
        return getSuffix(world.getName(), player.getUniqueId());
    }

    /**
     * Get a player's suffix in a specific world
     * @param world The world
     * @param name The player's name
     * @return The player's suffix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#getSuffix(String, UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public String getSuffix(String world, String name) throws UnknownPlayerException {
        return getSuffix(world, UUIDStore.getUniqueId(name));
    }

    /**
     * Set a player's suffix
     * @param uniqueId The player's uuid
     * @param suffix The new suffix
     */
    public abstract void setSuffix(UUID uniqueId, String suffix);

    /**
     * Set a player's suffix
     * @param player The player
     * @param suffix The new suffix
     * @see TrunkChat#setSuffix(UUID, String) Redirects to this method by default
     */
    public void setSuffix(OfflinePlayer player, String suffix) {
        setSuffix(player.getUniqueId(), suffix);
    }

    /**
     * Set a player's suffix
     * @param name The player's name
     * @param suffix The new suffix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#setSuffix(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public void setSuffix(String name, String suffix) throws UnknownPlayerException {
        setSuffix(UUIDStore.getUniqueId(name), suffix);
    }

    /**
     * Set a player's suffix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param suffix The new suffix
     * @see TrunkChat#setSuffix(UUID, String) Redirects to this method by default
     */
    public void setSuffix(String world, UUID uniqueId, String suffix) {
        setSuffix(uniqueId, suffix);
    }

    /**
     * Set a player's suffix in a specific world
     * @param world The world
     * @param player The player
     * @param suffix The new suffix
     * @see TrunkChat#setSuffix(UUID, String) Redirects to this method by default
     */
    public void setSuffix(String world, OfflinePlayer player, String suffix) {
        setSuffix(world, player.getUniqueId(), suffix);
    }

    /**
     * Set a player's suffix in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param suffix The new suffix
     * @see TrunkChat#setSuffix(String, UUID, String) Redirects to this method by default
     */
    public void setSuffix(World world, UUID uniqueId, String suffix) {
        setSuffix(world.getName(), uniqueId, suffix);
    }

    /**
     * Set a player's suffix in a specific world
     * @param world The world
     * @param player The player
     * @param suffix The new suffix
     * @see TrunkChat#setSuffix(String, UUID, String) Redirects to this method by default
     */
    public void setSuffix(World world, OfflinePlayer player, String suffix) {
        setSuffix(world.getName(), player.getUniqueId(), suffix);
    }

    /**
     * Set a player's suffix in a specific world
     * @param world The world
     * @param name The player's name
     * @param suffix The new suffix
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkChat#setSuffix(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public void setSuffix(String world, String name, String suffix) throws UnknownPlayerException {
        setSuffix(world, UUIDStore.getUniqueId(name), suffix);
    }

    /**
     * Get a player's groups
     * @param uniqueId The player's uuid
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(UUID) Redirects to this method by default
     */
    public Iterable<String> getGroups(UUID uniqueId) {
        return perms.getPlayerGroups(uniqueId);
    }

    /**
     * Get a player's groups
     * @param player The player
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(OfflinePlayer) Redirects to this method by default
     */
    public Iterable<String> getGroups(OfflinePlayer player) {
        return perms.getPlayerGroups(player);
    }

    /**
     * Get a player's groups
     * @param name The player's name
     * @return The player's groups
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPlayerGroups(String) Redirects to this method by default
     */
    public Iterable<String> getGroups(String name) throws UnknownPlayerException {
        return perms.getPlayerGroups(name);
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(String, UUID) Redirects to this method by default
     */
    public Iterable<String> getGroups(String world, UUID uniqueId) {
        return perms.getPlayerGroups(world, uniqueId);
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param player The player
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(World, UUID) Redirects to this method by default
     */
    public Iterable<String> getGroups(String world, OfflinePlayer player) {
        return perms.getPlayerGroups(world, player);
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(World, UUID) Redirects to this method by default
     */
    public Iterable<String> getGroups(World world, UUID uniqueId) {
        return perms.getPlayerGroups(world, uniqueId);
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param player The player
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(World, OfflinePlayer) Redirects to this method by default
     */
    public Iterable<String> getGroups(World world, OfflinePlayer player) {
        return perms.getPlayerGroups(world, player);
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param name The player's name
     * @return The player's groups
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPlayerGroups(String, String) Redirects to this method by default
     */
    public Iterable<String> getGroups(String world, String name) throws UnknownPlayerException {
        return perms.getPlayerGroups(world, name);
    }

    /**
     * Get a player's primary group
     * @param uniqueId The player's uuid
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(UUID uniqueId) {
        return perms.getPrimaryGroup(uniqueId);
    }

    /**
     * Get a player's primary group
     * @param player The player
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(OfflinePlayer) Redirects to this method by default
     */
    public String getPrimaryGroup(OfflinePlayer player) {
        return perms.getPrimaryGroup(player.getUniqueId());
    }

    /**
     * Get a player's primary group
     * @param name The player's name
     * @return The player's primary group
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPrimaryGroup(String) Redirects to this method by default
     */
    public String getPrimaryGroup(String name) throws UnknownPlayerException {
        return perms.getPrimaryGroup(name);
    }

    /**
     * Get a player's primary group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(String, UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(String world, UUID uniqueId) {
        return perms.getPrimaryGroup(world, uniqueId);
    }

    /**
     * Get a player's primary group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(World, UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(World world, UUID uniqueId) {
        return perms.getPrimaryGroup(world, uniqueId);
    }

    /**
     * Gets a player's group in a specific world
     * @param world The world
     * @param player The player
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(String, OfflinePlayer) Redirects to this method by default
     */
    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return perms.getPrimaryGroup(world, player);
    }

    /**
     * Gets a player's group in a specific world
     * @param world The world
     * @param player The player
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(World, OfflinePlayer) Redirects to this method by default
     */
    public String getPrimaryGroup(World world, OfflinePlayer player) {
        return perms.getPrimaryGroup(world, player);
    }

    /**
     * Gets a player's group in a specific world
     * @param world The world
     * @param name The player
     * @return The player's primary group
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPrimaryGroup(String, String) Redirects to this method by default
     */
    public String getPrimaryGroup(String world, String name) throws UnknownPlayerException {
        return perms.getPrimaryGroup(world, name);
    }

    /**
     * Check whether a player is in a group
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(UUID uniqueId, String group) {
        return perms.playerInGroup(uniqueId, group);
    }

    /**
     * Check whether a player is in a group
     * @param player The player
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(OfflinePlayer, String) Redirects to this method by default
     */
    public boolean playerInGroup(OfflinePlayer player, String group) {
        return perms.playerInGroup(player.getUniqueId(), group);
    }

    /**
     * Check whether a player is in a group
     * @param name The player's name
     * @param group The group
     * @return Whether the player is in the group
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerInGroup(String, String) Redirects to this method by default
     */
    public boolean playerInGroup(String name, String group) throws UnknownPlayerException {
        return perms.playerInGroup(name, group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(String world, UUID uniqueId, String group) {
        return perms.playerInGroup(world, uniqueId, group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(World, UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(World world, UUID uniqueId, String group) {
        return perms.playerInGroup(world, uniqueId, group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the player is in a group
     * @see TrunkPermissions#playerInGroup(String, OfflinePlayer, String) Redirects to this method by default
     */
    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return perms.playerInGroup(world, player, group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the player is in a group
     * @see TrunkPermissions#playerInGroup(World, OfflinePlayer, String) Redirects to this method by default
     */
    public boolean playerInGroup(World world, OfflinePlayer player, String group) {
        return perms.playerInGroup(world, player, group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param name The player's name
     * @param group The group
     * @return Whether the player is in a group
     * @throws UnknownPlayerException If a player cannot be found
     * @see TrunkPermissions#playerInGroup(String, String, String) Redirects to this method by default
     */
    public boolean playerInGroup(String world, String name, String group) throws UnknownPlayerException {
        return perms.playerInGroup(world, name, group);
    }

    /**
     * Get a group's prefix
     * @param group The group
     * @return The group's prefix
     */
    public abstract String getGroupPrefix(String group);

    /**
     * Get a grou's prefix in a specific world
     * @param world The world
     * @param group The group
     * @return The group's prefix
     * @see TrunkChat#getGroupPrefix(String) Redirects to this method by default
     */
    public String getGroupPrefix(String world, String group) {
        return getGroupPrefix(group);
    }

    /**
     * Set a group's prefix
     * @param group The group
     * @param prefix The new prefix
     */
    public abstract void setGroupPrefix(String group, String prefix);

    /**
     * Set a group's prefix in a specific world
     * @param world The world
     * @param group The group
     * @param prefix The new prefix
     * @see TrunkChat#setGroupPrefix(String, String) Redirects to this method by default
     */
    public void setGroupPrefix(String world, String group, String prefix) {
        setGroupPrefix(group, prefix);
    }

    /**
     * Get a group's suffix
     * @param group The group
     * @return The group's suffix
     */
    public abstract String getGroupSuffix(String group);

    /**
     * Get a group's suffix in a specific world
     * @param world The world
     * @param group The group
     * @return The group's suffix
     * @see TrunkChat#getGroupSuffix(String) Redirects to this method by default
     */
    public String getGroupSuffix(String world, String group) {
        return getGroupSuffix(group);
    }

    /**
     * Set a group's suffix in a specific world
     * @param group The group
     * @param suffix The new suffix
     */
    public abstract void setGroupSuffix(String group, String suffix);

    /**
     * Set a group's suffix in a specific world
     * @param world The world
     * @param group The group
     * @param suffix The suffix
     * @see TrunkChat#setGroupSuffix(String, String) Redirects to this method by default
     */
    public void setGroupSuffix(String world, String group, String suffix) {
        setGroupSuffix(group, suffix);
    }

    /**
     * Get all the groups
     * @return All the groups
     * @see TrunkPermissions#getGroups() Redirects to this method by default
     */
    public Iterable<String> getGroups() {
        return perms.getGroups();
    }

    /**
     * Get a boolean player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract boolean getBooleanPlayerOption(String world, UUID uniqueId, String node, boolean defaultValue);

    /**
     * Get a boolean player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getBooleanPlayerOption(String, UUID, String, boolean) Redirects to this method by default
     */
    public boolean getBooleanPlayerOption(World world, UUID uniqueId, String node, boolean defaultValue) {
        return getBooleanPlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    /**
     * Get a boolean player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getBooleanPlayerOption(String, UUID, String, boolean) Redirects to this method by default
     */
    public boolean getBooleanPlayerOption(String world, OfflinePlayer player, String node, boolean defaultValue) {
        return getBooleanPlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    /**
     * Get a boolean player option
     * @param world The world
     * @param player The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getBooleanPlayerOption(String, UUID, String, boolean) Redirects to this method by default
     */
    public boolean getBooleanPlayerOption(World world, OfflinePlayer player, String node, boolean defaultValue) {
        return getBooleanPlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    /**
     * Set a boolean player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     */
    public abstract void setBooleanPlayerOption(String world, UUID uniqueId, String node, boolean value);

    /**
     * Set a boolean player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setBooleanPlayerOption(String, UUID, String, boolean) Redirects to this method by default
     */
    public void setBooleanPlayerOption(World world, UUID uniqueId, String node, boolean value) {
        setBooleanPlayerOption(world.getName(), uniqueId, node, value);
    }

    /**
     * Set a boolean player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setBooleanPlayerOption(String, UUID, String, boolean) Redirects to this method by default
     */
    public void setBooleanPlayerOption(String world, OfflinePlayer player, String node, boolean value) {
        setBooleanPlayerOption(world, player.getUniqueId(), node, value);
    }

    /**
     * Set a boolean player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setBooleanPlayerOption(String, UUID, String, boolean) Redirects to this method by default
     */
    public void setBooleanPlayerOption(World world, OfflinePlayer player, String node, boolean value) {
        setBooleanPlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    /**
     * Get an integer player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract int getIntegerPlayerOption(String world, UUID uniqueId, String node, int defaultValue);

    /**
     * Get an integer player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getIntegerPlayerOption(String, UUID, String, int) Redirects to this method by default
     */
    public int getIntegerPlayerOption(World world, UUID uniqueId, String node, int defaultValue) {
        return getIntegerPlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    /**
     * Get an integer player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getIntegerPlayerOption(String, UUID, String, int) Redirects to this method by default
     */
    public int getIntegerPlayerOption(String world, OfflinePlayer player, String node, int defaultValue) {
        return getIntegerPlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    /**
     * Get an integer player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getIntegerPlayerOption(String, UUID, String, int) Redirects to this method by default
     */
    public int getIntegerPlayerOption(World world, OfflinePlayer player, String node, int defaultValue) {
        return getIntegerPlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    /**
     * Set an integer player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     */
    public abstract void setIntegerPlayerOption(String world, UUID uniqueId, String node, int value);

    /**
     * Set an integer player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setIntegerPlayerOption(String, UUID, String, int) Redirects to this method by default
     */
    public void setIntegerPlayerOption(World world, UUID uniqueId, String node, int value) {
        setIntegerPlayerOption(world.getName(), uniqueId, node, value);
    }

    /**
     * Set an integer player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setIntegerPlayerOption(String, UUID, String, int) Redirects to this method by default
     */
    public void setIntegerPlayerOption(String world, OfflinePlayer player, String node, int value) {
        setIntegerPlayerOption(world, player.getUniqueId(), node, value);
    }

    /**
     * Set an integer player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setIntegerPlayerOption(String, UUID, String, int) Redirects to this method by default
     */
    public void setIntegerPlayerOption(World world, OfflinePlayer player, String node, int value) {
        setIntegerPlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    /**
     * Get a double player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract double getDoublePlayerOption(String world, UUID uniqueId, String node, double defaultValue);

    /**
     * Get a double player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getDoublePlayerOption(String, UUID, String, double) Redirects to this method by default
     */
    public double getDoublePlayerOption(World world, UUID uniqueId, String node, double defaultValue) {
        return getDoublePlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    /**
     * Get a double player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getDoublePlayerOption(String, UUID, String, double) Redirects to this method by default
     */
    public double getDoublePlayerOption(String world, OfflinePlayer player, String node, double defaultValue) {
        return getDoublePlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    /**
     * Get a double player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getDoublePlayerOption(String, UUID, String, double) Redirects to this method by default
     */
    public double getDoublePlayerOption(World world, OfflinePlayer player, String node, double defaultValue) {
        return getDoublePlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    /**
     * Set a double player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     */
    public abstract void setDoublePlayerOption(String world, UUID uniqueId, String node, double value);

    /**
     * Set a double player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setDoublePlayerOption(String, UUID, String, double) Redirects to this method by default
     */
    public void setDoublePlayerOption(World world, UUID uniqueId, String node, double value) {
        setDoublePlayerOption(world.getName(), uniqueId, node, value);
    }

    /**
     * Set a double player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setDoublePlayerOption(String, UUID, String, double) Redirects to this method by default
     */
    public void setDoublePlayerOption(String world, OfflinePlayer player, String node, double value) {
        setDoublePlayerOption(world, player.getUniqueId(), node, value);
    }

    /**
     * Set a double player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setDoublePlayerOption(String, UUID, String, double) Redirects to this method by default
     */
    public void setDoublePlayerOption(World world, OfflinePlayer player, String node, double value) {
        setDoublePlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    /**
     * Get a String player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract String getStringPlayerOption(String world, UUID uniqueId, String node, String defaultValue);

    /**
     * Get a String player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getStringPlayerOption(String, UUID, String, String) Redirects to this method by default
     */
    public String getStringPlayerOption(World world, UUID uniqueId, String node, String defaultValue) {
        return getStringPlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    /**
     * Get a String player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getStringPlayerOption(String, UUID, String, String) Redirects to this method by default
     */
    public String getStringPlayerOption(String world, OfflinePlayer player, String node, String defaultValue) {
        return getStringPlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    /**
     * Get a String player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getStringPlayerOption(String, UUID, String, String) Redirects to this method by default
     */
    public String getStringPlayerOption(World world, OfflinePlayer player, String node, String defaultValue) {
        return getStringPlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    /**
     * Set a String player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     */
    public abstract void setStringPlayerOption(String world, UUID uniqueId, String node, String value);

    /**
     * Set a String player option
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setStringPlayerOption(String, UUID, String, String) Redirects to this method by default
     */
    public void setStringPlayerOption(World world, UUID uniqueId, String node, String value) {
        setStringPlayerOption(world.getName(), uniqueId, node, value);
    }

    /**
     * Set a String player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setStringPlayerOption(String, UUID, String, String) Redirects to this method by default
     */
    public void setStringPlayerOption(String world, OfflinePlayer player, String node, String value) {
        setStringPlayerOption(world, player.getUniqueId(), node, value);
    }

    /**
     * Set a String player option
     * @param world The world
     * @param player The player
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setStringPlayerOption(String, UUID, String, String) Redirects to this method by default
     */
    public void setStringPlayerOption(World world, OfflinePlayer player, String node, String value) {
        setStringPlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    /**
     * Get a boolean group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract boolean getBooleanGroupOption(String world, String group, String node, boolean defaultValue);

    /**
     * Get a boolean group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getBooleanGroupOption(String, String, String, boolean) Redirects to this method by default
     */
    public boolean getBooleanGroupOption(World world, String group, String node, boolean defaultValue) {
        return getBooleanGroupOption(world.getName(), group, node, defaultValue);
    }

    /**
     * Set a boolean group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     */
    public abstract void setBooleanGroupOption(String world, String group, String node, boolean value);

    /**
     * Set a boolean group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     * @see TrunkChat#setBooleanGroupOption(String, String, String, boolean) Redirects to this method by default
     */
    public void setBooleanGroupOption(World world, String group, String node, boolean value) {
        setBooleanGroupOption(world.getName(), group, node, value);
    }

    /**
     * Get an integer group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract int getIntegerGroupOption(String world, String group, String node, int defaultValue);

    /**
     * Get an integer group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getIntegerGroupOption(String, String, String, int) Redirects to this method by default
     */
    public int getIntegerGroupOption(World world, String group, String node, int defaultValue) {
        return getIntegerGroupOption(world.getName(), group, node, defaultValue);
    }

    /**
     * Set an integer group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     */
    public abstract void setIntegerGroupOption(String world, String group, String node, int value);

    /**
     * Set an integer group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     */
    public void setIntegerGroupOption(World world, String group, String node, int value) {
        setIntegerGroupOption(world.getName(), group, node, value);
    }

    /**
     * Get a double group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract double getDoubleGroupOption(String world, String group, String node, double defaultValue);

    /**
     * Get a double group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getDoubleGroupOption(String, String, String, double) Redirects to this method by default
     */
    public double getDoubleGroupOption(World world, String group, String node, double defaultValue) {
        return getDoubleGroupOption(world.getName(), group, node, defaultValue);
    }

    /**
     * Set a double group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     */
    public abstract void setDoubleGroupOption(String world, String group, String node, double value);

    /**
     * Set a double group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     */
    public void setDoubleGroupOption(World world, String group, String node, double value) {
        setDoubleGroupOption(world.getName(), group, node, value);
    }

    /**
     * Get a String group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     */
    public abstract String getStringGroupOption(String world, String group, String node, String defaultValue);

    /**
     * Get a double group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param defaultValue The default value if it can't be found
     * @return The option's value
     * @see TrunkChat#getDoubleGroupOption(String, String, String, double) Redirects to this method by default
     */
    public String getStringGroupOption(World world, String group, String node, String defaultValue) {
        return getStringGroupOption(world.getName(), group, node, defaultValue);
    }

    /**
     * Set a String group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     */
    public abstract void setStringGroupOption(String world, String group, String node, String value);

    /**
     * Set a String group option
     * @param world The world
     * @param group The group
     * @param node The option node
     * @param value The new value
     */
    public void setStringGroupOption(World world, String group, String node, String value) {
        setStringGroupOption(world.getName(), group, node, value);
    }

}
