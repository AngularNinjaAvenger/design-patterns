package creational;

import creational.singleton.Preferences;

public class main {
    public static void main(String[] args) {
        // only one instane of the prefrence class can be created
        Preferences.getInstance().helloSingleton();
    }
}