package com.trophonix.trunk.api.events;

import com.trophonix.trunk.api.TrunkAPI;
import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

/**
 * Created by Lucas on 4/18/17.
 */
public class APIRegisterEvent extends Event implements Cancellable {

    private static HandlerList handlerList = new HandlerList();

    private final Plugin plugin;
    private final TrunkAPI api;
    private final Class apiType;

    private boolean cancelled;

    public APIRegisterEvent(Plugin plugin, TrunkAPI api) {
        this.plugin = plugin;
        this.api = api;
        this.apiType = api.getClass().getSuperclass();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public TrunkAPI getAPI() {
        return api;
    }

    public Class getAPIType() {
        return apiType;
    }

    public boolean isChat() {
        return apiType.equals(TrunkChat.class);
    }

    public boolean isEconomy() {
        return apiType.equals(TrunkEconomy.class);
    }

    public boolean isPermissions() {
        return apiType.equals(TrunkPermissions.class);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
