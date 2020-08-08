/**
 * Exercise 33: (2) Write a program that displays the current value of a directory called
 * "base directory" and prompts you for a new value. Use the Preferences API to store the value
 */
package eckel.io;
import java.util.prefs.*;
/**
public class Ex33 {
        public static void main(String[] args) throws Exception {
            Preferences prefs = Preferences
                    .userNodeForPackage(PreferencesDemo.class);
            prefs.put("Location", "Oz");
            prefs.put("Footwear", "Ruby Slippers");
            prefs.putInt("Companions", 4);
            prefs.putBoolean("Are there witches?", true);
            int usageCount = prefs.getInt("UsageCount", 0);
            usageCount++;
            prefs.putInt("UsageCount", usageCount);
            for(String key : prefs.keys())
                print(key + ": "+ prefs.get(key, null));
// You must always provide a default value:
            print("How many companions does Dorothy have? " +
                    prefs.getInt("Companions", 0));
        }
    } /* Output: (Sample)
Location: Oz
Footwear: Ruby Slippers
Companions: 4
Are there witches?: true
UsageCount: 53
How many companions does Dorothy have? 4
*///:~

