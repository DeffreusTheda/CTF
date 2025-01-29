extends VideoStreamPlayer

func _ready():
    play()
    await finished
    print("Video finished playing")
