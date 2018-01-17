public class MusicNode{
	public String songName;	
	public String artist;	
	//public String compData;			// computer data
	public String genre;
	public String album;
	public MusicNode leftChild;         // this node's left child
	public MusicNode rightChild; 
	public MusicNode(){
		songName = "";
		artist = "";
		genre = "";
		album = "";
	}
	public MusicNode(String [] info){
		songName = info[0];
		artist = info[1];
		album = info[2];
		genre = info[3];
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public MusicNode(String sG, String a, String g, String alb){
		this.songName = sG;
		this.artist = a;
		this.genre = g;
		this.album = alb;
	}
	@Override
	public String toString() {
		return "MusicNode [songName = " + songName + ", artist= " + artist + ", genre= " + genre + ", album= " + album +"]";
	}
}