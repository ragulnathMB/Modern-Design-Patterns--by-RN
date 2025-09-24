# Adapter Pattern Example in Python
# Media player adapting different audio formats

from abc import ABC, abstractmethod

class MediaPlayer(ABC):
    @abstractmethod
    def play(self, filename):
        pass

class Mp3Player:
    def play_mp3(self, filename):
        return f"Playing MP3: {filename}"

class Mp4Player:
    def play_mp4(self, filename):
        return f"Playing MP4: {filename}"

class VlcPlayer:
    def play_vlc(self, filename):
        return f"Playing VLC: {filename}"

class MediaAdapter(MediaPlayer):
    def __init__(self, audio_type):
        self.audio_type = audio_type.lower()
        if self.audio_type == "mp4":
            self.player = Mp4Player()
        elif self.audio_type == "vlc":
            self.player = VlcPlayer()
    
    def play(self, filename):
        if self.audio_type == "mp4":
            return self.player.play_mp4(filename)
        elif self.audio_type == "vlc":
            return self.player.play_vlc(filename)

class AudioPlayer(MediaPlayer):
    def play(self, audio_type, filename):
        if audio_type.lower() == "mp3":
            mp3_player = Mp3Player()
            return mp3_player.play_mp3(filename)
        elif audio_type.lower() in ["mp4", "vlc"]:
            adapter = MediaAdapter(audio_type)
            return adapter.play(filename)
        else:
            return f"Invalid media. {audio_type} format not supported"

def main():
    player = AudioPlayer()
    print(player.play("mp3", "song.mp3"))
    print(player.play("mp4", "video.mp4"))
    print(player.play("vlc", "movie.vlc"))
    print(player.play("avi", "clip.avi"))

if __name__ == "__main__":
    main()
