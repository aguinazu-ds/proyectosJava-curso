import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> artist_UntoOthers_LyricsMap = new HashMap<>();
        artist_UntoOthers_LyricsMap.put("Nightfall", "Energy, running free, you know not that you come to me...");
        artist_UntoOthers_LyricsMap.put("Don't Waste Your Time", "A marker is lain on the space...");
        artist_UntoOthers_LyricsMap.put("Mana", "I see the mirror in your eyes again...");
        artist_UntoOthers_LyricsMap.put("Cosmic Overdrive", "When I find the highway, will you be there?...");
        System.out.println("Extrayendo letra de canción titulada Mana: " + artist_UntoOthers_LyricsMap.get("Mana"));
        artist_UntoOthers_LyricsMap.forEach((k,v) -> System.out.println("Nombre siguiente canción: " + k));
    }
}
