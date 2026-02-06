extends Sprite2D

@export var fall_speed: float = 1.23

var init_y_pos: float = -360

var has_passed: bool = false
var pass_threshold = 300.0

func _init():
    set_process(false)

func _process(delta):
    global_position += Vector2(0, fall_speed * 100 * delta)


    if global_position.y > pass_threshold and not $Timer.is_stopped():
        $Timer.stop()
        has_passed = true

func Setup(target_x: float, target_frame: int):
    global_position = Vector2(target_x, init_y_pos)
    frame = target_frame

    set_process(true)



func _on_destroy_timer_timeout():
    queue_free()
