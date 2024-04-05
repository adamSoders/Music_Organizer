import java.io.*; 
import java.util.*; 

public class Album implements Iterable<Album>{
	
	
	Set<SoundClip> soundclips = new HashSet<SoundClip>(); 
	private List<Album> subAlbums = new ArrayList<Album>();
	private String name;
	private Album parentAlbum = null;
	
	public Album(String albumName) {
		name = albumName;
		parentAlbum = this;
	}
	
	public boolean addTrack(SoundClip track) {
		if(soundclips.add(track)) {
			if(parentAlbum!=null) {
				parentAlbum.addTrack(track);
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteTrack(SoundClip track) {
		if(containtsTrack(track)) {
			soundclips.remove(track);
			for(Album subAlbum : subAlbums){
				 deleteTrack(track);
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean containtsTrack(SoundClip track) {
		return soundclips.contains(track);
	}
	
	public void addSubAlbum(String albumName) {
		Album subAlbum = new Album(albumName);
		subAlbums.add(subAlbum);
	}
	
	public boolean removeSubAlbum(Album subAlbum) {
		if(containtsAlbum(subAlbum)) {
			return subAlbums.remove(subAlbum);
		}else {
			return false;
		}	
	}
	
	public boolean containtsAlbum(Album subAlbum) {
		return subAlbums.contains(subAlbum);
	}
	
	public Iterator<Album> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
