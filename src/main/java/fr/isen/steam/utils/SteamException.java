package fr.isen.steam.utils;

import java.io.IOException;

/**
 * Created by pierrezemb on 21/02/2016.
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
