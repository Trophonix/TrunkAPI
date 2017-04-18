package com.trophonix.trunk.api.economy;

/**
 * Created by Lucas on 4/12/17.
 */
public class EconomyResponse {

    public enum Result {
        SUCCESS, FAILURE, ERROR;

        public net.milkbowl.vault.economy.EconomyResponse.ResponseType toVault() {
            switch (this) {
                case SUCCESS: return net.milkbowl.vault.economy.EconomyResponse.ResponseType.SUCCESS;
                case FAILURE: return net.milkbowl.vault.economy.EconomyResponse.ResponseType.FAILURE;
            }
            return net.milkbowl.vault.economy.EconomyResponse.ResponseType.NOT_IMPLEMENTED;
        }

        static Result fromVault(net.milkbowl.vault.economy.EconomyResponse.ResponseType type) {
            switch (type) {
                case SUCCESS: return SUCCESS;
                case FAILURE: return FAILURE;
            }
            return ERROR;
        }
    }

    private final Result result;
    private String message;
    private Number previousBalance;
    private Number newBalance;

    public EconomyResponse(Result result, String message, Number previousBalance, Number newBalance) {
        this.result = result;
        this.message = message;
        this.previousBalance = previousBalance;
        this.newBalance = newBalance;
    }

    public EconomyResponse(Result result, Number previousBalance, Number newBalance) {
        this.result = result;
        this.previousBalance = previousBalance;
        this.newBalance = newBalance;
    }

    public EconomyResponse(Result result, String message) {
        this.result = result;
        this.message = message;
    }

    public EconomyResponse(Result result) {
        this.result = result;
    }

    public EconomyResponse(boolean bool) { this.result = bool ? Result.SUCCESS : Result.FAILURE; }

    public Result getResult() {
        return result;
    }

    public boolean hasMessage() {
        return message != null;
    }

    public String getMessage() {
        return message;
    }

    public Number getPreviousBalance() {
        return previousBalance;
    }

    public Number getNewBalance() {
        return newBalance;
    }

    public net.milkbowl.vault.economy.EconomyResponse toVault() {
        return new net.milkbowl.vault.economy.EconomyResponse(Math.abs(newBalance.doubleValue() - previousBalance.doubleValue()), newBalance.doubleValue(), result.toVault(), message);
    }

    public static EconomyResponse fromVault(net.milkbowl.vault.economy.EconomyResponse vault) {
        return new EconomyResponse(Result.fromVault(vault.type), vault.errorMessage, vault.amount, vault.balance);
    }

}
