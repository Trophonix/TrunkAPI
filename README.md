# TrunkAPI: A New Abstraction Library for Bukkit plugins

#### If you are a server owner/user looking for the Spigot/Bukkit plugin, Trunk, [Click Here](https://github.com/Trophonix/Trunk). If you're a developer looking to support Trunk in your plugin, read on!

I love Vault. It's an extremely useful API for developers, and has had a massive effect on many types of plugins. However, as you can tell by the [Commit History](https://github.com/MilkBowl/VaultAPI/commits/master), it's gone a bit inactive. It uses out-of-date methods and generally just leaves a lot to be desired. So, I made something that I hope fixes those problems: Trunk.

### Why Trunk?

Trunk is designed by a developer, for developers. It has a lot of extra methods for developers to use when hooking into Trunk, and on the flip side, the extra methods redirect to others by default, so if you're making an economy or permissions plugin, you only need to override a few! It's simple and convenient for everyone. 

### Okay, but why "Trunk"?

At first, I was just trying to think of another word for Vault. I know, super original. Then, after I decided on "Trunk", I realized it had more meaning to the project than I first thought. Not only is it like a trunk of useful information, but it's also like a tree trunk - it forms a stable base on which people's awesome plugins can grow and flourish.

### Fine. I'm sold. What now?

Well, as I said before, it's pretty simple!

---

First, I HIGHLY recommend using [Maven](https://www.tutorialspoint.com/maven/). It makes using APIs like Spigot and Trunk WAY easier. If it's not your jam, feel free to import the [VaultAPI Jar](https://github.com/Trophonix/TrunkAPI/releases) the old-fashioned way.

If you're using Maven, you simply have to add my Maven repository and the VaultAPI dependency to your pom.xml, like so:

```XML
<project>
...
<repositories>
    <repository>
        <id>trunk</id>
        <url>http://trophonix.com:8081/repository/public/</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.trophonix</groupId>
        <artifactId>TrunkAPI</artifactId>
        <version>1.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
...
</project>
```
Now you should be ready to continue.

----

If you're making a plugin that needs to access money, prefixes, etc. there are multiple simple ways you can do that!

1. **Use the getAPI method**

Here is a simple plugin which adds players' prefixes to the join message.

```Java
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.trophonix.trunk.api.TrunkAPI;
import com.trophonix.trunk.api.chat.TrunkChat;

public class Example extends JavaPlugin implements Listener {
    
    private TrunkChat chat;
    
    @Override
    public void onEnable() {
        if (!setupChat()) { // Setup chat, and if it was unsuccessful, shutdown.
            getLogger().warning("Failed to hook into Trunk! Disabling...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("Successfully hooked into Trunk!");
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String prefix = chat.getPrefix(event.getPlayer());
        if (prefix != null) {
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', prefix) // Color the prefix with & color codes
            + event.getPlayer().getDisplayName() // Add the player's display name
            + ChatColor.YELOW + " has joined!");
        }
    }
    
    // Setup Trunk chat
    private boolean setupChat() {
        chat = TrunkAPI.getAPI(TrunkChat.class);
        return chat != null; // If it was able to successfully find a chat, returns true.
    }
    
}
```
That's it. **Your plugin will now work with both Trunk AND Vault chat/perms/economy plugins!**

2. **Use Bukkit service providers directly**

If you're more inclined for the way Vault does it, you can do that too!

```
private boolean setupChat() {
    RegisteredServiceProvider<TrunkChat> rsp = Bukkit.getServer().getServicesManager().getRegistration(TrunkChat.class);
    if (rsp != null) {
        chat = rsp.getProvider();
    }
    return chat != null;
}
```

---

If you're making an economy or permissions plugin and are looking to provide access to data stored in your plugin to Trunk-supported plugins, that's relatively simple too!

You can see an example here: [TrunkExample](https://github.com/trophonix/TrunkExample)

I have some more good news. Registering through Trunk automatically supports Vault plugins as well, so you only have to do it once!
