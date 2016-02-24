package fr.isen.steam.utils;

/**
 * Created by pierrezemb on 21/02/2016.
 * Steam exception, extending Runtime Exception
 */
public class SteamException extends RuntimeException {

    public SteamException() {
        super();
    }
    public SteamException(String s) {
        super(s);
    }
    public SteamException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public SteamException(Throwable throwable) {
        super(throwable);
    }
}
