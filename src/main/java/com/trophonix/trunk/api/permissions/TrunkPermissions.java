package com.trophonix.trunk.api.permissions;

import com.trophonix.trunk.api.UUIDStore;
import com.trophonix.trunk.api.TrunkAPI;
import com.trophonix.trunk.api.exceptions.UnknownPlayerException;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * Created by Lucas on 4/12/17.
 */
@SuppressWarnings("WeakerAccess")
public abstract class TrunkPermissions extends TrunkAPI {

    private final Plugin plugin;

    /**
     * TrunkPermissions constructor
     * @param plugin The registering plugin
     */
    public TrunkPermissions(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * @return The registering plugin
     */
    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Check whether a CommandSender has a permission
     * @param sender The CommandSender
     * @param node The permission node
     * @return Whether the CommandSender has the permission
     */
    public abstract boolean has(CommandSender sender, String node);

    /**
     * Check whether a player has a permission
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the player has the permission
     */
    public abstract boolean playerHas(UUID uniqueId, String node);

    /**
     * Check whether a player has a permission
     * @param player The player
     * @param node The permission node
     * @return Whether the player has the permission
     * @see TrunkPermissions#playerHas(UUID, String) Redirects to this method by default
     */
    public boolean playerHas(OfflinePlayer player, String node) {
        return playerHas(player.getUniqueId(), node);
    }

    /**
     * Check whether a player has a permission
     * @param name The player's name
     * @param node The permission node
     * @return Whether the player has the permission
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerHas(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerHas(String name, String node) throws UnknownPlayerException {
        return playerHas(UUIDStore.getUniqueId(name), node);
    }

    /**
     * Check whether a player has a permission in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the player has the permission in the world
     */
    public abstract boolean playerHas(String world, UUID uniqueId, String node);

    /**
     * Check whether a player has a permission in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the player has the permission in the world
     * @see TrunkPermissions#playerHas(String, UUID, String) Redirects to this method by default
     */
    public boolean playerHas(World world, UUID uniqueId, String node) {
        return playerHas(world.getName(), uniqueId, node);
    }

    /**
     * Check whether a player has a permission in a specific world
     * @param world The world
     * @param player The player
     * @param node The permission node
     * @return Whether the player has the permission in the world
     * @see TrunkPermissions#playerHas(String, UUID, String) Redirects to this method by default
     */
    public boolean playerHas(String world, OfflinePlayer player, String node) {
        return playerHas(world, player.getUniqueId(), node);
    }

    /**
     * Check whether a player has a permission in a specific world
     * @param world The world
     * @param player The player's uuid
     * @param node The permission node
     * @return Whether the player has the permission in the world
     * @see TrunkPermissions#playerHas(String, UUID, String) Redirects to this method by default
     */
    public boolean playerHas(World world, OfflinePlayer player, String node) {
        return playerHas(world.getName(), player.getUniqueId(), node);
    }

    /**
     * Check whether a player has a permission in a specific world
     * @param world The world
     * @param name The player's name
     * @param node The permission node
     * @return Whether the player has the permission in the world
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerHas(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerHas(String world, String name, String node) throws UnknownPlayerException {
        return playerHas(world, UUIDStore.getUniqueId(name), node);
    }

    /**
     * Add a permission to a player
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the addition was successful
     */
    public abstract boolean playerAdd(UUID uniqueId, String node);

    /**
     * Add a permission to a player
     * @param player The player
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAdd(UUID, String) Redirects to this method by default
     */
    public boolean playerAdd(OfflinePlayer player, String node) {
        return playerAdd(player.getUniqueId(), node);
    }

    /**
     * Add a permission to a player
     * @param name The player's name
     * @param node The permission node
     * @return Whether the addition was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerAdd(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerAdd(String name, String node) throws UnknownPlayerException {
        return playerAdd(UUIDStore.getUniqueId(name), node);
    }

    /**
     * Add a permission to a player in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAdd(UUID, String) Redirects to this method by default
     */
    public boolean playerAdd(String world, UUID uniqueId, String node) {
        return playerAdd(uniqueId, node);
    }

    /**
     * Add a permission to a player in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAdd(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAdd(World world, UUID uniqueId, String node) {
        return playerAdd(world.getName(), uniqueId, node);
    }

    /**
     * Add a permission to a player in a specific world
     * @param world The world
     * @param player The player
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAdd(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAdd(String world, OfflinePlayer player, String node) {
        return playerAdd(world, player.getUniqueId(), node);
    }

    /**
     * Add a permission to a player in a specific world
     * @param world The world
     * @param player The player
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAdd(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAdd(World world, OfflinePlayer player, String node) {
        return playerAdd(world.getName(), player.getUniqueId(), node);
    }

    /**
     * Add a permission to a player in a specific world
     * @param world The world
     * @param name The player's name
     * @param node The permission node
     * @return Whether the addition was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerAdd(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerAdd(String world, String name, String node) throws UnknownPlayerException {
        return playerAdd(world, UUIDStore.getUniqueId(name), node);
    }

    /**
     * Remove a permission from a player
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the removal was successful
     */
    public abstract boolean playerRemove(UUID uniqueId, String node);

    /**
     * Remove a permission from a player
     * @param player The player
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemove(UUID, String) Redirects to this method by default
     */
    public boolean playerRemove(OfflinePlayer player, String node) {
        return playerRemove(player.getUniqueId(), node);
    }

    /**
     * Remove a permission from a player
     * @param name The player's name
     * @param node The permission node
     * @return Whether the removal was successful
     * @throws UnknownPlayerException If player cannot be found
     * @see TrunkPermissions#playerRemove(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerRemove(String name, String node) throws UnknownPlayerException {
        return playerRemove(UUIDStore.getUniqueId(name), node);
    }

    /**
     * Remove a permission from a player in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemove(UUID, String) Redirects to this method by default
     */
    public boolean playerRemove(String world, UUID uniqueId, String node) {
        return playerRemove(uniqueId, node);
    }

    /**
     * Remove a permission from a player in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemove(String, UUID, String) Redirects to this method by default
     */
    public boolean playerRemove(World world, UUID uniqueId, String node) {
        return playerRemove(world.getName(), uniqueId, node);
    }

    /**
     * Remove a permission from a player in a specific world
     * @param world The world
     * @param player The player
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemove(String, UUID, String) Redirects to this method by default
     */
    public boolean playerRemove(String world, OfflinePlayer player, String node) {
        return playerRemove(world, player.getUniqueId(), node);
    }

    /**
     * Remove a permission from a player in a specific world
     * @param world The world
     * @param player The player
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemove(String, UUID, String) Redirects to this method by default
     */
    public boolean playerRemove(World world, OfflinePlayer player, String node) {
        return playerAdd(world.getName(), player.getUniqueId(), node);
    }

    /**
     * Remove a permission from a player in a specific world
     * @param world The world
     * @param name The player's name
     * @param node The permission node
     * @return Whether the removal was successful
     * @throws UnknownPlayerException If player cannot be found
     * @see TrunkPermissions#playerRemove(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerRemove(String world, String name, String node) throws UnknownPlayerException {
        return playerRemove(world, UUIDStore.getUniqueId(name), node);
    }

    /**
     * Add a transient (temporary) permission to a player
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the addition was successful
     */
    public abstract boolean playerAddTransient(UUID uniqueId, String node);

    /**
     * Add a transient (temporary) permission to a player
     * @param player The player
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddTransient(UUID, String) Redirects to this method by default
     */
    public boolean playerAddTransient(OfflinePlayer player, String node) {
        return playerAddTransient(player.getUniqueId(), node);
    }

    /**
     * Add a transient (temporary) permission to a player
     * @param name The player's name
     * @param node The permission node
     * @return Whether the addition was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerAddTransient(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerAddTransient(String name, String node) throws UnknownPlayerException {
        return playerAddTransient(UUIDStore.getUniqueId(name), node);
    }

    /**
     * Add a transient (temporary) permission to a player in a specific world
     * @param world the world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddTransient(UUID, String) Redirects to this method by default
     */
    public boolean playerAddTransient(String world, UUID uniqueId, String node) {
        return playerAddTransient(uniqueId, node);
    }

    /**
     * Add a transient (temporary) permission to a player in a specific world
     * @param world the world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddTransient(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAddTransient(World world, UUID uniqueId, String node) {
        return playerAddTransient(world.getName(), uniqueId, node);
    }

    /**
     * Add a transient (temporary) permission to a player in a specific world
     * @param world the world
     * @param player The player
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddTransient(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAddTransient(String world, OfflinePlayer player, String node) {
        return playerAddTransient(world, player.getUniqueId(), node);
    }

    /**
     * Add a transient (temporary) permission to a player in a specific world
     * @param world the world
     * @param player The player
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddTransient(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAddTransient(World world, OfflinePlayer player, String node) {
        return playerAddTransient(world.getName(), player.getUniqueId(), node);
    }

    /**
     * Add a transient (temporary) permission to a player in a specific world
     * @param world the world
     * @param name The player's name
     * @param node The permission node
     * @return Whether the addition was successful
     * @throws UnknownPlayerException If player cannot be found
     * @see TrunkPermissions#playerAddTransient(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerAddTransient(String world, String name, String node) throws UnknownPlayerException {
        return playerAddTransient(world, UUIDStore.getUniqueId(name), node);
    }

    /**
     * Remove a transient (temporary) permission from a player
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the removal was successful
     */
    public abstract boolean playerRemoveTransient(UUID uniqueId, String node);

    /**
     * Remove a transient (temporary) permission from a player
     * @param player The player
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveTransient(UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveTransient(OfflinePlayer player, String node) {
        return playerRemoveTransient(player.getUniqueId(), node);
    }

    /**
     * Remove a transient (temporary) permission from a player
     * @param name The player's name
     * @param node The permission node
     * @return Whether the removal was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerRemoveTransient(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerRemoveTransient(String name, String node) throws UnknownPlayerException {
        return playerRemoveTransient(UUIDStore.getUniqueId(name), node);
    }

    /**
     * Remove a transient (temporary) permission from a player in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveTransient(UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveTransient(String world, UUID uniqueId, String node) {
        return playerRemove(uniqueId, node);
    }

    /**
     * Remove a transient (temporary) permission from a player in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveTransient(UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveTransient(World world, UUID uniqueId, String node) {
        return playerRemoveTransient(world.getName(), uniqueId, node);
    }

    /**
     * Remove a transient (temporary) permission from a player in a specific world
     * @param world The world
     * @param player The player
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveTransient(UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveTransient(String world, OfflinePlayer player, String node) {
        return playerRemoveTransient(world, player.getUniqueId(), node);
    }

    /**
     * Remove a transient (temporary) permission from a player in a specific world
     * @param world The world
     * @param player The player
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveTransient(UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveTransient(World world, OfflinePlayer player, String node) {
        return playerRemoveTransient(world.getName(), player.getUniqueId(), node);
    }

    /**
     * Remove a transient (temporary) permission from a player in a specific world
     * @param world The world
     * @param name The player's name
     * @param node The permission node
     * @return Whether the removal was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerRemoveTransient(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerRemoveTransient(String world, String name, String node) throws UnknownPlayerException {
        return playerRemoveTransient(world, UUIDStore.getUniqueId(name), node);
    }

    /**
     * @return Whether the permission api supports groups
     */
    public abstract boolean hasGroupSupport();

    /**
     * Add a player to a group
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the addition was successful
     */
    public abstract boolean playerAddGroup(UUID uniqueId, String group);

    /**
     * Add a player to a group
     * @param player The player
     * @param group The group
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddGroup(UUID, String) Redirects to this method by default
     */
    public boolean playerAddGroup(OfflinePlayer player, String group) {
        return playerAddGroup(player.getUniqueId(), group);
    }

    /**
     * Add a player to a group
     * @param name The player's name
     * @param group The group
     * @return Whether the addition was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerAddGroup(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerAddGroup(String name, String group) throws UnknownPlayerException {
        return playerAddGroup(UUIDStore.getUniqueId(name), group);
    }

    /**
     * Add a player to a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddGroup(UUID, String) Redirects to this method by default
     */
    public boolean playerAddGroup(String world, UUID uniqueId, String group) {
        return playerAddGroup(uniqueId, group);
    }

    /**
     * Add a player to a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAddGroup(World world, UUID uniqueId, String group) {
        return playerAddGroup(world.getName(), uniqueId, group);
    }

    /**
     * Add a player to a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAddGroup(String world, OfflinePlayer player, String group) {
        return playerAddGroup(world, player.getUniqueId(), group);
    }

    /**
     * Add a player to a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the addition was successful
     * @see TrunkPermissions#playerAddGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerAddGroup(World world, OfflinePlayer player, String group) {
        return playerAddGroup(world.getName(), player.getUniqueId(), group);
    }

    /**
     * Add a player to a group in a specific world
     * @param world The world
     * @param name The player's name
     * @param group The group
     * @return Whether the addition was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerAddGroup(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerAddGroup(String world, String name, String group) throws UnknownPlayerException {
        return playerAddGroup(world, UUIDStore.getUniqueId(name), group);
    }

    /**
     * Remove a player from a group
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the removal was successful
     */
    public abstract boolean playerRemoveGroup(UUID uniqueId, String group);

    /**
     * Remove a player from a group
     * @param player The player
     * @param group The group
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveGroup(UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveGroup(OfflinePlayer player, String group) {
        return playerRemoveGroup(player.getUniqueId(), group);
    }

    /**
     * Remove a player from a group
     * @param name The player's name
     * @param group The group
     * @return Whether the removal was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerRemoveGroup(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerRemoveGroup(String name, String group) throws UnknownPlayerException {
        return playerRemoveGroup(UUIDStore.getUniqueId(name), group);
    }

    /**
     * Remove a player from a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the removal was successful
     */
    public abstract boolean playerRemoveGroup(String world, UUID uniqueId, String group);

    /**
     * Remove a player from a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveGroup(World world, UUID uniqueId, String group) {
        return playerRemoveGroup(world.getName(), uniqueId, group);
    }

    /**
     * Remove a player from a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveGroup(String world, OfflinePlayer player, String group) {
        return playerRemoveGroup(world, player.getUniqueId(), group);
    }

    /**
     * Remove a player from a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the removal was successful
     * @see TrunkPermissions#playerRemoveGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerRemoveGroup(World world, OfflinePlayer player, String group) {
        return playerRemoveGroup(world.getName(), player.getUniqueId(), group);
    }

    /**
     * Remove a player from a group in a specific world
     * @param world The world
     * @param name The player's name
     * @param group The group
     * @return Whether the removal was successful
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerRemoveGroup(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerRemoveGroup(String world, String name, String group) throws UnknownPlayerException {
        return playerRemoveGroup(world, UUIDStore.getUniqueId(name), group);
    }

    /**
     * Check whether a player is in a group
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the player is in the group
     */
    public abstract boolean playerInGroup(UUID uniqueId, String group);

    /**
     * Check whether a player is in a group
     * @param player The player
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(OfflinePlayer player, String group) {
        return playerInGroup(player.getUniqueId(), group);
    }

    /**
     * Check whether a player is in a group
     * @param name The player's name
     * @param group The group
     * @return Whether the player is in the group
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerInGroup(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerInGroup(String name, String group) throws UnknownPlayerException {
        return playerInGroup(UUIDStore.getUniqueId(name), group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(String world, UUID uniqueId, String group) {
        return playerInGroup(uniqueId, group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(World world, UUID uniqueId, String group) {
        return playerInGroup(world.getName(), uniqueId, group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return playerInGroup(world, player.getUniqueId(), group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param player The player
     * @param group The group
     * @return Whether the player is in the group
     * @see TrunkPermissions#playerInGroup(String, UUID, String) Redirects to this method by default
     */
    public boolean playerInGroup(World world, OfflinePlayer player, String group) {
        return playerInGroup(world.getName(), player.getUniqueId(), group);
    }

    /**
     * Check whether a player is in a group in a specific world
     * @param world The world
     * @param name The player's name
     * @param group The group
     * @return Whether the player is in the group
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#playerInGroup(String, UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean playerInGroup(String world, String name, String group) throws UnknownPlayerException {
        return playerInGroup(world, UUIDStore.getUniqueId(name), group);
    }

    /**
     * Check whether a group has a permission
     * @param group The group
     * @param node The permission node
     * @return Whether the group has the permission
     */
    public abstract boolean groupHas(String group, String node);

    /**
     * Check whether a group has a permission
     * @param world The world
     * @param group The group
     * @param node The permission node
     * @return Whether the group has the permission
     * @see TrunkPermissions#groupHas(String, String) Redirects to this method by default
     */
    public boolean groupHas(String world, String group, String node) {
        return groupHas(group, node);
    }

    /**
     * Check whether a group has a permission
     * @param world The world
     * @param group The group
     * @param node The permission node
     * @return Whether the group has the permission
     * @see TrunkPermissions#groupHas(String, String, String) Redirects to this method by default
     */
    public boolean groupHas(World world, String group, String node) {
        return groupHas(world.getName(), group, node);
    }

    /**
     * Add a permission to a group
     * @param group The group
     * @param node The permission node
     * @return Whether the addition was successful
     */
    public abstract boolean groupAdd(String group, String node);

    /**
     * Add a permission to a group in a specific world
     * @param world The world
     * @param group The group
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#groupAdd(String, String) Redirects to this method by default
     */
    public boolean groupAdd(String world, String group, String node) {
        return groupAdd(group, node);
    }

    /**
     * Add a permission to a group in a specific world
     * @param world The world
     * @param group The group
     * @param node The permission node
     * @return Whether the addition was successful
     * @see TrunkPermissions#groupAdd(String, String, String) Redirects to this method by default
     */
    public boolean groupAdd(World world, String group, String node) {
        return groupAdd(world.getName(), group, node);
    }

    /**
     * Remove a permission from a group
     * @param group The group
     * @param node The permission node
     * @return Whether the removal was successful
     */
    public abstract boolean groupRemove(String group, String node);

    /**
     * Remove a permission from a group in a specific world
     * @param world The world
     * @param group The group
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#groupRemove(String, String) Redirects to this method by default
     */
    public boolean groupRemove(String world, String group, String node) {
        return groupRemove(group, node);
    }

    /**
     * Remove a permission from a group in a specific world
     * @param world The world
     * @param group The group
     * @param node The permission node
     * @return Whether the removal was successful
     * @see TrunkPermissions#groupRemove(String, String, String) Redirects to this method by default
     */
    public boolean groupRemove(World world, String group, String node) {
        return groupRemove(world.getName(), group, node);
    }

    /**
     * Get a player's groups
     * @param uniqueId The player's uuid
     * @return The player's groups
     */
    public abstract Iterable<String> getPlayerGroups(UUID uniqueId);

    /**
     * Get a player's groups
     * @param player The player
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(UUID) Redirects to this method by default
     */
    public Iterable<String> getPlayerGroups(OfflinePlayer player) {
        return getPlayerGroups(player.getUniqueId());
    }

    /**
     * Get a player's groups
     * @param name The player's name
     * @return The player's groups
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPlayerGroups(UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public Iterable<String> getPlayerGroups(String name) throws UnknownPlayerException {
        return getPlayerGroups(UUIDStore.getUniqueId(name));
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(UUID) Redirects to this method by default
     */
    public Iterable<String> getPlayerGroups(String world, UUID uniqueId) {
        return getPlayerGroups(uniqueId);
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param player The player
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(String, UUID) Redirects to this method by default
     */
    public Iterable<String> getPlayerGroups(String world, OfflinePlayer player) {
        return getPlayerGroups(world, player.getUniqueId());
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(String, UUID) Redirects to this method by default
     */
    public Iterable<String> getPlayerGroups(World world, UUID uniqueId) {
        return getPlayerGroups(world.getName(), uniqueId);
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param player The player's uuid
     * @return The player's groups
     * @see TrunkPermissions#getPlayerGroups(String, UUID) Redirects to this method by default
     */
    public Iterable<String> getPlayerGroups(World world, OfflinePlayer player) {
        return getPlayerGroups(world.getName(), player.getUniqueId());
    }

    /**
     * Get a player's groups in a specific world
     * @param world The world
     * @param name The player's name
     * @return The player's groups
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPlayerGroups(String, UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public Iterable<String> getPlayerGroups(String world, String name) throws UnknownPlayerException {
        return getPlayerGroups(world, UUIDStore.getUniqueId(name));
    }

    /**
     * Get a player's primary group
     * @param uniqueId The player's uuid
     * @return The player's primary group
     */
    public abstract String getPrimaryGroup(UUID uniqueId);

    /**
     * Get a player's primary group
     * @param player The player
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(OfflinePlayer player) {
        return getPrimaryGroup(player.getUniqueId());
    }

    /**
     * Get a player's primary group
     * @param name The player's name
     * @return The player's primary group
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPrimaryGroup(UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public String getPrimaryGroup(String name) throws UnknownPlayerException {
        return getPrimaryGroup(UUIDStore.getUniqueId(name));
    }

    /**
     * Get a player's primary group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(String world, UUID uniqueId) {
        return getPrimaryGroup(uniqueId);
    }

    /**
     * Get a player's primary group in a specific world
     * @param world The world
     * @param uniqueId The player's uuid
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(String, UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(World world, UUID uniqueId) {
        return getPrimaryGroup(world.getName(), uniqueId);
    }

    /**
     * Get a player's primary group in a specific world
     * @param world The world
     * @param player The player
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(String, UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return getPrimaryGroup(world, player.getUniqueId());
    }

    /**
     * Get a player's primary group in a specific world
     * @param world The world
     * @param player The player
     * @return The player's primary group
     * @see TrunkPermissions#getPrimaryGroup(String, UUID) Redirects to this method by default
     */
    public String getPrimaryGroup(World world, OfflinePlayer player) {
        return getPrimaryGroup(world.getName(), player.getUniqueId());
    }

    /**
     * Get a player's primary group in a specific world
     * @param world The world
     * @param name The player's name
     * @return The player's primary group
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkPermissions#getPrimaryGroup(String, UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public String getPrimaryGroup(String world, String name) throws UnknownPlayerException {
        return getPrimaryGroup(world, UUIDStore.getUniqueId(name));
    }

    /**
     * Get all the groups
     * @return All the groups
     */
    public abstract Iterable<String> getGroups();

    /**
     * Get all the groups in a specific world
     * @param world The world
     * @return All the groups
     * @see TrunkPermissions#getGroups() Redirects to this method by default
     */
    public Iterable<String> getGroups(String world) {
        return getGroups();
    }

    /**
     * Get all the groups in a specific world
     * @param world The world
     * @return All the groups
     * @see TrunkPermissions#getGroups(String) Redirects to this method by default
     */
    public Iterable<String> getGroups(World world) {
        return getGroups(world.getName());
    }

}
