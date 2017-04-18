package com.trophonix.trunk.api.economy;

import com.trophonix.trunk.api.UUIDStore;
import com.trophonix.trunk.api.TrunkAPI;
import com.trophonix.trunk.api.exceptions.UnknownPlayerException;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import java.util.Collections;
import java.util.UUID;

/**
 * Created by Lucas on 4/12/17.
 */
@SuppressWarnings("WeakerAccess")
public abstract class TrunkEconomy extends TrunkAPI {

    private final Plugin plugin;

    /**
     * TrunkEconomy constructor
     * @param plugin The registering plugin
     */
    public TrunkEconomy(Plugin plugin) {
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
     * @return How many digits to round fractions to
     */
    public abstract int getDigits();

    /**
     * Format a number into a 'pretty string'
     * @param amount Number to format
     * @return Formatted number
     */
    public abstract String format(Number amount);

    /**
     * @return The currency's name in plural form
     */
    public abstract String currencyNamePlural();

    /**
     * @return The currency's name in singular form
     */
    public abstract String currencyNameSingular();

    /**
     * @return The currency's representative symbol
     */
    public abstract String currencySymbol();

    /**
     * Check whether a player has an account (saved balance)
     * @param uniqueId The player's uuid
     * @return Whether the player has an account
     */
    public abstract boolean hasAccount(UUID uniqueId);

    /**
     * Check whether a player has an account (saved balance)
     * @param player The player
     * @return Whether the player has an account
     * @see TrunkEconomy#hasAccount(UUID) Redirects to this method by default
     */
    public boolean hasAccount(OfflinePlayer player) {
        return hasAccount(player.getUniqueId());
    }

    /**
     * Check whether a player has an account (saved balance)
     * @param name The player's name
     * @return Whether the player has an account
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#hasAccount(UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean hasAccount(String name) throws UnknownPlayerException {
        return hasAccount(UUIDStore.getUniqueId(name));
    }

    /**
     * Check whether a player has an account (saved balance) in a specific world
     * Returns whether they have a global account if not overridden
     * @param uniqueId The player's uuid
     * @param world The world
     * @return Whether the player has an account
     * @see TrunkEconomy#hasAccount(UUID) Redirects to this method by default
     */
    public boolean hasAccount(UUID uniqueId, String world) {
        return hasAccount(uniqueId);
    }

    /**
     * Check whether a player has an account (saved balance) in a specific world
     * Returns whether they have a global account if not overridden
     * @param player The player
     * @param world The world
     * @return Whether the player has an account
     * @see TrunkEconomy#hasAccount(UUID, String) Redirects to this method by default
     */
    public boolean hasAccount(OfflinePlayer player, String world) {
        return hasAccount(player.getUniqueId(), world);
    }

    /**
     * Create an account for a player
     * @param uniqueId The player's uuid
     * @return A response
     */
    public abstract EconomyResponse createAccount(UUID uniqueId);

    /**
     * Create an account for a player
     * @param player The player
     * @return A response
     * @see TrunkEconomy#createAccount(UUID) Redirects to this method by default
     */
    public EconomyResponse createAccount(OfflinePlayer player) {
        return createAccount(player.getUniqueId());
    }

    /**
     * Create an account for a player
     * @param name The player's name
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#createAccount(UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse createAccount(String name) throws UnknownPlayerException {
        return createAccount(UUIDStore.getUniqueId(name));
    }

    /**
     * Create an account for a player in a specific world
     * Redirects to creating a global account if not overridden
     * @param uniqueId The player's uuid
     * @param world The world
     * @return A response
     * @see TrunkEconomy#createAccount(UUID) Redirects to this method by default
     */
    public EconomyResponse createAccount(UUID uniqueId, String world) {
        return createAccount(uniqueId);
    }

    /**
     * Create an account for a player in a specific world
     * Redirects to creating a global account if not overridden
     * @param player The player
     * @param world The world
     * @return A response
     * @see TrunkEconomy#createAccount(UUID, String) Redirects to this method by default
     */
    public EconomyResponse createAccount(OfflinePlayer player, String world) {
        return createAccount(player.getUniqueId(), world);
    }

    /**
     * Get a player's global balance
     * @param uniqueId The player's unique id
     * @return The player's global balance
     */
    public abstract Number getBalance(UUID uniqueId);

    /**
     * Get a player's global balance
     * @param player The player
     * @return The player's global balance
     * @see TrunkEconomy#getBalance(UUID) Redirects to this method by default
     */
    public Number getBalance(OfflinePlayer player) {
        return getBalance(player.getUniqueId());
    }

    /**
     * Get a player's global balance
     * @param name The player's name
     * @return The player's global balance
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#getBalance(UUID) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public Number getBalance(String name) throws UnknownPlayerException {
        return getBalance(UUIDStore.getUniqueId(name));
    }

    /**
     * Get a player's balance in a specific world
     * Returns the player's global balance if not overridden
     * @param uniqueId The player's unique id
     * @param world The world
     * @return The player's balance in the world
     * @see TrunkEconomy#getBalance(UUID) Redirects to this method by default
     */
    public Number getBalance(UUID uniqueId, String world) {
        return getBalance(uniqueId);
    }

    /**
     * Get a player's balance in a specific world
     * Returns the player's global balance if not overridden
     * @param player The player
     * @param world The world
     * @return The player's balance in the world
     * @see TrunkEconomy#getBalance(UUID, String) Redirects to this method by default
     */
    public Number getBalance(OfflinePlayer player, String world) {
        return getBalance(player.getUniqueId(), world);
    }

    /**
     * Get a player's balance in a specific world
     * @param name The player's name
     * @param world The world
     * @return The player's balance in the world
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#getBalance(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public Number getBalance(String name, String world) throws UnknownPlayerException {
        return getBalance(UUIDStore.getUniqueId(name), world);
    }

    /**
     * Set a player's global balance
     * @param uniqueId The player's uuid
     * @param balance The player's new balance
     * @return A response
     */
    public abstract EconomyResponse setBalance(UUID uniqueId, Number balance);

    /**
     * Set a player's global balance
     * @param player The player
     * @param balance The player's new balance
     * @return A response
     * @see TrunkEconomy#setBalance(UUID, Number) Redirects to this method by default
     */
    public EconomyResponse setBalance(OfflinePlayer player, Number balance) {
        return setBalance(player.getUniqueId(), balance);
    }

    /**
     * Set a player's global balance
     * @param name The player's name
     * @param balance The player's new balance
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#setBalance(UUID, Number) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse setBalance(String name, Number balance) throws UnknownPlayerException {
        return setBalance(UUIDStore.getUniqueId(name), balance);
    }

    /**
     * Set a player's balance in a specific world
     * Redirects to setting the player's global balance if not overridden
     * @param uniqueId The player's uuid
     * @param balance The player's new balance
     * @param world The world
     * @return A response
     * @see TrunkEconomy#setBalance(UUID, Number) Redirects to this method by default
     */
    public EconomyResponse setBalance(UUID uniqueId, Number balance, String world) {
        return setBalance(uniqueId, balance);
    }

    /**
     * Set a player's balance in a specific world
     * Redirects to setting the player's global balance if not overridden
     * @param player The player
     * @param balance The player's new balance
     * @param world The world
     * @return A response
     * @see TrunkEconomy#setBalance(UUID, Number, String) Redirects to this method by default
     */
    public EconomyResponse setBalance(OfflinePlayer player, Number balance, String world) {
        return setBalance(player.getUniqueId(), balance, world);
    }

    /**
     * Set a player's balance in a specific world
     * Redirects to setting the player's global balance if not overridden
     * @param name The player's name
     * @param balance The player's new balance
     * @param world The world
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#setBalance(UUID, Number, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse setBalance(String name, Number balance, String world) throws UnknownPlayerException {
        return setBalance(UUIDStore.getUniqueId(name), balance, world);
    }

    /**
     * Check whether a player's balance exceeds an amount
     * @param uniqueId The player's uuid
     * @param amount Amount to check
     * @return Whether the player has the amount
     */
    public abstract boolean has(UUID uniqueId, Number amount);

    /**
     * Check whether a player's balance exceeds an amount
     * @param player The player
     * @param amount Amount to check
     * @return Whether the player has the amount
     * @see TrunkEconomy#has(UUID, Number) Redirects to this method by default
     */
    public boolean has(OfflinePlayer player, Number amount) {
        return has(player.getUniqueId(), amount);
    }

    /**
     * Check whether a player's global balance exceeds an amount
     * @param name The player's name
     * @param amount Amount to check
     * @return Whether the player has the amount
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#has(UUID, Number) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean has(String name, Number amount) throws UnknownPlayerException {
        return has(UUIDStore.getUniqueId(name), amount);
    }

    /**
     * Check whether a player's balance in a specific world exceeds an amount
     * Redirects to global balance if not overridden
     * @param uniqueId The player's uuid
     * @param amount Amount to check
     * @param world The world
     * @return Whether the player has the amount
     * @see TrunkEconomy#has(UUID, Number) Redirects to this method by default
     */
    public boolean has(UUID uniqueId, Number amount, String world) {
        return has(uniqueId, amount);
    }

    /**
     * Check whether a player's balance in a specific world exceeds an amount
     * Redirects to global balance if not overridden
     * @param player The player
     * @param amount Amount to check
     * @param world The world
     * @return Whether the player has the amount
     * @see TrunkEconomy#has(UUID, Number, String) Redirects to this method by default
     */
    public boolean has(OfflinePlayer player, Number amount, String world) {
        return has(player.getUniqueId(), amount, world);
    }

    /**
     * Check whether a player's balance in a specific world exceeds an amount
     * @param name The player's name
     * @param amount Amount to check
     * @param world The world
     * @return Whether the player has the amount
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#has(UUID, Number, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean has(String name, Number amount, String world) throws UnknownPlayerException {
        return has(UUIDStore.getUniqueId(name), amount, world);
    }

    /**
     * Deposit into a player's balance
     * @param uniqueId The player's uuid
     * @param amount Amount to deposit
     * @return A response
     */
    public abstract EconomyResponse deposit(UUID uniqueId, Number amount);

    /**
     * Deposit into a player's balance
     * @param player The player's uuid
     * @param amount Amount to deposit
     * @return A response
     * @see TrunkEconomy#deposit(UUID, Number) Redirects to this method by default
     */
    public EconomyResponse deposit(OfflinePlayer player, Number amount) {
        return deposit(player.getUniqueId(), amount);
    }

    /**
     * Deposit into a player's balance
     * @param name The player's name
     * @param amount Amount to deposit
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#deposit(UUID, Number) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse deposit(String name, Number amount) throws UnknownPlayerException {
        return deposit(UUIDStore.getUniqueId(name), amount);
    }

    /**
     * Deposit into a player's balance in a specific world
     * Redirects to global balance if not overridden
     * @param uniqueId The player's uuid
     * @param amount Amount to deposit
     * @param world The world
     * @return A response
     * @see TrunkEconomy#deposit(UUID, Number) Redirects to this method by default
     */
    public EconomyResponse deposit(UUID uniqueId, Number amount, String world) {
        return deposit(uniqueId, amount);
    }

    /**
     * Deposit into a player's balance in a specific world
     * @param player The player's uuid
     * @param amount Amount to deposit
     * @param world The world
     * @return A response
     * @see TrunkEconomy#deposit(UUID, Number, String) Redirects to this method by default
     */
    public EconomyResponse deposit(OfflinePlayer player, Number amount, String world) {
        return deposit(player.getUniqueId(), amount, world);
    }

    /**
     * Deposit into a player's balance into a specific world
     * @param name The player's name
     * @param amount Amount to deposit
     * @param world The world
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#deposit(UUID, Number, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse deposit(String name, Number amount, String world) throws UnknownPlayerException {
        return deposit(UUIDStore.getUniqueId(name), amount, world);
    }

    /**
     * Withdraw from a player's balance
     * @param uniqueId The player's uuid
     * @param amount Amount to withdraw
     * @return A response
     */
    public abstract EconomyResponse withdraw(UUID uniqueId, Number amount);

    /**
     * Withdraw from a player's balance
     * @param player The player
     * @param amount Amount to withdraw
     * @return A response
     * @see TrunkEconomy#withdraw(UUID, Number) Redirects to this method by default
     */
    public EconomyResponse withdraw(OfflinePlayer player, Number amount) {
        return withdraw(player.getUniqueId(), amount);
    }

    /**
     * Withdraw from a player's balance in a specific world
     * Redirects to global balance if not overridden
     * @param uniqueId The player's uuid
     * @param amount Amount to withdraw
     * @param world The world
     * @return A response
     * @see TrunkEconomy#withdraw(UUID, Number) Redirects to this method by default
     */
    public EconomyResponse withdraw(UUID uniqueId, Number amount, String world) {
        return withdraw(uniqueId, amount);
    }

    /**
     * Withdraw from a player's balance in a specific world
     * Redirects to global balance if not overridden
     * @param player The player
     * @param amount Amount to withdraw
     * @param world The world
     * @return A response
     * @see TrunkEconomy#withdraw(UUID, Number, String) Redirects to this method by default
     */
    public EconomyResponse withdraw(OfflinePlayer player, Number amount, String world) {
        return withdraw(player.getUniqueId(), amount, world);
    }

    /**
     * Withdraws from a player's balance in a specific world
     * @param name The player's name
     * @param amount Amount to withdraw
     * @param world The world
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#withdraw(UUID, Number, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse withdraw(String name, Number amount, String world) throws UnknownPlayerException {
        return withdraw(UUIDStore.getUniqueId(name), amount, world);
    }

    /**
     * @return Whether the hook supports banks
     */
    public abstract boolean hasBankSupport();

    /**
     * Create a bank
     * Returns failure if not overridden
     * @param name Name of bank
     * @return A response
     */
    public EconomyResponse createBank(String name) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Delete a bank
     * Returns failure if not overridden
     * @param name Name of bank
     * @return A response
     */
    public EconomyResponse deleteBank(String name) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Get the current balance of a bank (for supporting banks having limited money)
     * Returns Double.MAX_VALUE if not overridden
     * @param bank The bank
     * @return The bank's current balance
     */
    public Number getBankBalance(String bank) {
        return Double.MAX_VALUE;
    }

    /**
     * Set the current balance of a bank (for supporting banks having limited money)
     * Returns failure if not overridden
     * @param bank The bank
     * @param balance New balance
     * @return A response
     */
    public EconomyResponse setBankBalance(String bank, Number balance) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Check whether a bank's balance exceeds an amount
     * Returns whether getBankBalance is greater than or equal to amount if not overridden
     * @param bank The bank
     * @param amount Amount to check
     * @return Whether the bank has the amount
     * @see TrunkEconomy#getBankBalance(String)
     */
    public boolean bankHas(String bank, Number amount) {
        return getBankBalance(bank).doubleValue() >= amount.doubleValue();
    }

    /**
     * Get an Iterable of all the banks
     * Returns empty list if not overridden
     * @return A list of all the banks
     */
    public Iterable<String> getBanks() {
        return Collections.emptyList();
    }

    /**
     * Check whether a player has an account (saved balance) in a bank
     * Returns false if not overridden
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @return Whether the player has an account in the bank
     */
    public boolean hasBankAccount(UUID uniqueId, String bank) {
        return false;
    }

    /**
     * Check whether a player has an account (saved balance) in a bank
     * Returns false if not overridden
     * @param player The player
     * @param bank The bank
     * @return Whether the player has an account in the bank
     * @see TrunkEconomy#hasBankAccount(UUID, String) Redirects to this method by default
     */
    public boolean hasBankAccount(OfflinePlayer player, String bank) {
        return hasBankAccount(player.getUniqueId(), bank);
    }

    /**
     * Check whether a player has an account (saved balance) in a bank
     * Returns false if not overridden
     * @param name The player's name
     * @param bank The bank
     * @return Whether the player has an account in the bank
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#hasBankAccount(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean hasBankAccount(String name, String bank) throws UnknownPlayerException {
        return hasBankAccount(UUIDStore.getUniqueId(name), bank);
    }

    /**
     * Create a bank account in a bank for a player
     * Returns failure if not overridden
     * @param uniqueId The player's unique id
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse createBankAccount(UUID uniqueId, String bank) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Create a bank account in a bank for a player
     * Returns failure if not overridden
     * @param player The player
     * @param bank The bank
     * @return A response
     * @see TrunkEconomy#createBankAccount(UUID, String) Redirects to this method by default
     */
    public EconomyResponse createBankAccount(OfflinePlayer player, String bank) {
        return createBankAccount(player.getUniqueId(), bank);
    }

    /**
     * Create a bank account in a bank for a player
     * @param name The player's name
     * @param bank The bank
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#createBankAccount(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse createBankAccount(String name, String bank) throws UnknownPlayerException {
        return createBankAccount(UUIDStore.getUniqueId(name), bank);
    }

    /**
     * Delete bank account in a bank for a player
     * Returns failure if not overridden
     * @param uniqueId The player's unique id
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse deleteBankAccount(UUID uniqueId, String bank) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Delete bank account in a bank for a player
     * Returns failure if not overridden
     * @param player The player
     * @param bank The bank
     * @return A response
     * @see TrunkEconomy#deleteBankAccount(UUID, String) Redirects to this method by default
     */
    public EconomyResponse deleteBankAccount(OfflinePlayer player, String bank) {
        return deleteBankAccount(player.getUniqueId(), bank);
    }

    /**
     * Delete a bank account in a bank for a player
     * Returns failure if not overridden
     * @param name The player's name
     * @param bank The bank
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#deleteBankAccount(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse deleteBankAccount(String name, String bank) throws UnknownPlayerException {
        return deleteBankAccount(UUIDStore.getUniqueId(name), bank);
    }

    /**
     * Get a player's balance in a bank
     * Returns 0 if not overridden
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @return The player's balance in the bank
     */
    public Number getBankAccountBalance(UUID uniqueId, String bank) {
        return 0;
    }

    /**
     * Get a player's balance in a bank
     * Returns 0 if not overridden
     * @param player The player
     * @param bank The bank
     * @return The player's balance in the bank
     * @see TrunkEconomy#getBankAccountBalance(UUID, String) Redirects to this method by default
     */
    public Number getBankAccountBalance(OfflinePlayer player, String bank) {
        return getBankAccountBalance(player.getUniqueId(), bank);
    }

    /**
     * Get a player's balance in a bank
     * Returns 0 if not overridden
     * @param name The player's name
     * @param bank The bank
     * @return The player's balance in the bank
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#getBankAccountBalance(UUID, String) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public Number getBankAccountBalance(String name, String bank) throws UnknownPlayerException {
        return getBankAccountBalance(UUIDStore.getUniqueId(name), bank);
    }

    /**
     * Set a player's balance in a bank
     * Returns failure if not overridden
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @param balance The new balance
     * @return A response
     */
    public EconomyResponse setBankAccountBalance(UUID uniqueId, String bank, Number balance) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Set a player's balance in a bank
     * Returns failure if not overridden
     * @param player The player
     * @param bank The bank
     * @param balance The new balance
     * @return A response
     * @see TrunkEconomy#setBankAccountBalance(UUID, String, Number) Redirects to this method by default
     */
    public EconomyResponse setBankAccountBalance(OfflinePlayer player, String bank, Number balance) {
        return setBankAccountBalance(player.getUniqueId(), bank, balance);
    }

    /**
     * Set a player's balance in a bank
     * Returns failure if not overridden
     * @param name The player's name
     * @param bank The bank
     * @param balance The new balance
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#setBankAccountBalance(UUID, String, Number) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse setBankAccountBalance(String name, String bank, Number balance) throws UnknownPlayerException {
        return setBankAccountBalance(UUIDStore.getUniqueId(name), bank, balance);
    }

    /**
     * Check whether a player's balance in a bank exceeds an amount
     * Returns false if not overridden
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @param amount The amount
     * @return Whether the player's balance in the bank exceeds the amount
     */
    public boolean bankAccountHas(UUID uniqueId, String bank, Number amount) {
        return false;
    }

    /**
     * Check whether a player's balance in a bank exceeds an amount
     * Returns false if not overridden
     * @param player The player
     * @param bank The bank
     * @param amount The amount
     * @return Whether the player's balance in the bank exceeds the amount
     * @see TrunkEconomy#bankAccountHas(UUID, String, Number) Redirects to this method by default
     */
    public boolean bankAccountHas(OfflinePlayer player, String bank, Number amount) {
        return bankAccountHas(player.getUniqueId(), bank, amount);
    }

    /**
     * Check whether a player's balance in a bank exceeds an amount
     * Returns false if not overridden
     * @param name The player's name
     * @param bank The bank
     * @param amount The amount
     * @return Whether the player's balance in the bank exceeds the amount
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#bankAccountHas(UUID, String, Number) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public boolean bankAccountHas(String name, String bank, Number amount) throws UnknownPlayerException {
        return bankAccountHas(UUIDStore.getUniqueId(name), bank, amount);
    }

    /**
     * Deposit into a player's balance in a bank
     * Returns failure if not overridden
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @param amount Amount to deposit
     * @return A response
     */
    public EconomyResponse depositBankAccount(UUID uniqueId, String bank, Number amount) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Deposit into a player's balance in a bank
     * Returns failure if not overridden
     * @param player The player
     * @param bank The bank
     * @param amount Amount to deposit
     * @return A response
     * @see TrunkEconomy#depositBankAccount(UUID, String, Number) Redirects to this method by default
     */
    public EconomyResponse depositBankAccount(OfflinePlayer player, String bank, Number amount) {
        return depositBankAccount(player.getUniqueId(), bank, amount);
    }

    /**
     * Deposit into a player's balance in a bank
     * Returns failure if not overridden
     * @param name The player's name
     * @param bank The bank
     * @param amount Amount to deposit
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#depositBankAccount(UUID, String, Number) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse depositBankAccount(String name, String bank, Number amount) throws UnknownPlayerException {
        return depositBankAccount(UUIDStore.getUniqueId(name), bank, amount);
    }

    /**
     * Withdraw from a player's balance in a bank
     * Returns failure if not overridden
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @param amount Amount to withdraw
     * @return A response
     */
    public EconomyResponse withdrawBankAccount(UUID uniqueId, String bank, Number amount) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Withdraw from a player's balance in a bank
     * Returns failure if not overridden
     * @param player The player
     * @param bank The bank
     * @param amount Amount to withdraw
     * @return A response
     * @see TrunkEconomy#withdrawBankAccount(UUID, String, Number) Redirects to this method by default
     */
    public EconomyResponse withdrawBankAccount(OfflinePlayer player, String bank, Number amount) {
        return withdrawBankAccount(player.getUniqueId(), bank, amount);
    }

    /**
     * Withdraw from a player's balance in a bank
     * Returns failure if not overridden
     * @param name The player's name
     * @param bank The bank
     * @param amount Amount to withdraw
     * @return A response
     * @throws UnknownPlayerException If the player cannot be found
     * @see TrunkEconomy#withdrawBankAccount(UUID, String, Number) Redirects to this method by default
     * @see UUIDStore#getUniqueId(String)
     */
    public EconomyResponse withdrawBankAccount(String name, String bank, Number amount) throws UnknownPlayerException {
        return withdrawBankAccount(UUIDStore.getUniqueId(name), bank, amount);
    }

}
