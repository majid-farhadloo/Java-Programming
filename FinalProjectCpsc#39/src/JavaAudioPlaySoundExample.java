import java.io.FileInputStream;
import java.net.URL;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class MainClass implements java.applet.AudioClip {
	private AudioData audiodata;

	private AudioDataStream audiostream;

	private ContinuousAudioDataStream continuousaudiostream;

	static int length;

	public MainClass(URL url) throws java.io.IOException {
		audiodata = new AudioStream(url.openStream()).getData();
		audiostream = null;
		continuousaudiostream = null;
	}

	public MainClass(String filename) throws java.io.IOException {
		FileInputStream fis = new FileInputStream(filename);
		AudioStream audioStream = new AudioStream(fis);
		audiodata = audioStream.getData();
		audiostream = null;
		continuousaudiostream = null;
	}

	public void play() {
		audiostream = new AudioDataStream(audiodata);
		AudioPlayer.player.start(audiostream);
	}

	public void loop() {
		continuousaudiostream = new ContinuousAudioDataStream(audiodata);
		AudioPlayer.player.start(continuousaudiostream);
	}

	public void stop() {
		if (audiostream != null)
			AudioPlayer.player.stop(audiostream);
		if (continuousaudiostream != null)
			AudioPlayer.player.stop(continuousaudiostream);
	}

	public static void main(String args[]) throws Exception {
		URL url1 = new URL("http://localhost:8080/audio/1.au");
		URL url2 = new URL("http://localhost:8080/audio/2.au");
		MainClass sac1 = new MainClass(url1);
		MainClass sac2 = new MainClass(url2);
		MainClass sac3 = new MainClass("1.au");
		sac1.play();
		sac2.loop();
		sac3.play();
		try { // Delay for loop
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
		}
		sac2.stop();
	}
}

