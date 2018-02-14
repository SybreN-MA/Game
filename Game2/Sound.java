package Game2;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Sound {

    public void Music(String file) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(file + ".wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(0);
    }
}