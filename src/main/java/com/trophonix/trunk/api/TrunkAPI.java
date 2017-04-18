package com.trophonix.trunk.api;

import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.api.events.APIRegisterEvent;
import com.trophonix.trunk.api.exceptions.APIRegisterException;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;

/**
 * Created by Lucas on 4/12/17.
 */
public abstract class TrunkAPI {

    /**
     * Get the plugin related to this hook
     * @return The plugin
     */
    public abstract Plugin getPlugin();

    /**
     * Register a trunk economy
     * @param api The economy to register
     * @throws APIRegisterException If the registration fails
     */
    public static void register(TrunkEconomy api) throws APIRegisterException {
        if (getAPI(TrunkEconomy.class) != null) {
            throw new APIRegisterException("Attempted to register a api of a type which is already registered!");
        }
        APIRegisterEvent event = new APIRegisterEvent(api.getPlugin(), api);
        Bukkit.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled())
            Bukkit.getServer().getServicesManager().register(TrunkEconomy.class, api, api.getPlugin(), ServicePriority.Highest);
    }

    /**
     * Register trunk permissions
     * @param api The permissions to register
     * @throws APIRegisterException If the registration fails
     */
    public static void register(TrunkPermissions api) throws APIRegisterException {
        if (getAPI(TrunkPermissions.class) != null) {
            throw new APIRegisterException("Attempted to register a api of a type which is already registered!");
        }
        APIRegisterEvent event = new APIRegisterEvent(api.getPlugin(), api);
        Bukkit.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled())
            Bukkit.getServer().getServicesManager().register(TrunkPermissions.class, api, api.getPlugin(), ServicePriority.Highest);
    }

    /**
     * Register a trunk chat
     * @param api The chat to register
     * @throws APIRegisterException If the registration fails
     */
    public static void register(TrunkChat api) throws APIRegisterException {
        if (getAPI(TrunkChat.class) != null) {
            throw new APIRegisterException("Attempted to register a api of a type which is already registered!");
        }
        APIRegisterEvent event = new APIRegisterEvent(api.getPlugin(), api);
        Bukkit.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled())
            Bukkit.getServer().getServicesManager().register(TrunkChat.class, api, api.getPlugin(), ServicePriority.Highest);
    }

    /**
     * Unregister an API
     * @param api The api
     */
    public static void unregister(TrunkAPI api) {
        Bukkit.getServer().getServicesManager().unregister(api);
    }

    /**
     * Unregister all APIs registered by a plugin
     * @param plugin The plugin
     */
    public static void unregisterAll(Plugin plugin) {
        Bukkit.getServer().getServicesManager().unregisterAll(plugin);
    }

    /**
     * Get an API of a type
     * @param clazz The class of the type API
     * @param <T> The type of API
     * @return The API of type or null if one is not found
     */
    public static <T extends TrunkAPI> T getAPI(Class<T> clazz) {
        RegisteredServiceProvider<T> rsp = Bukkit.getServer().getServicesManager().getRegistration(clazz);
        if (rsp != null) {
            return rsp.getProvider();
        }
        return null;
    }

}
