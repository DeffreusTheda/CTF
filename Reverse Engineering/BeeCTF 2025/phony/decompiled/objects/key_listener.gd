extends Sprite2D

@onready var falling_key = preload("res://objects/falling_key.tscn")
@onready var score_text = preload("res://objects/score_press_text.tscn")
@export var key_name: String = ""

@export var falling_key_container: Node2D
@export var score_text_container: Node2D

var falling_key_queue = []

var perfect_press_threshold: float = 30
var great_press_threshold: float = 50
var good_press_threshold: float = 60
var ok_press_threshold: float = 80

var perfect_press_score: float = 250
var great_press_score: float = 100
var good_press_score: float = 50
var ok_press_score: float = 20

func _ready():
    $GlowOverlay.frame = frame + 4
    Signals.CreateFallingKey.connect(CreateFallingKey)

func _process(delta):
    if Input.is_action_just_pressed(key_name):
        Signals.KeyListenerPress.emit(key_name, frame)

    if falling_key_queue.size() > 0:
        var falling_key_instance = falling_key_queue.front()

        if not is_instance_valid(falling_key_instance):
            falling_key_queue.pop_front()
            return

        if falling_key_instance.has_passed:
            var missed_key = falling_key_queue.pop_front()

            spawn_score_text("MISS")
            Signals.ResetCombo.emit()

            missed_key.queue_free()

        elif Input.is_action_just_pressed(key_name):
            var key_to_pop = falling_key_queue.pop_front()

            var distance_from_pass = abs(key_to_pop.pass_threshold - key_to_pop.global_position.y)

            $AnimationPlayer.stop()
            $AnimationPlayer.play("key_hit")

            var press_score_text: String = ""
            if distance_from_pass < perfect_press_threshold:
                Signals.IncrementScore.emit(perfect_press_score)
                press_score_text = "PERFECT"
                Signals.IncrementCombo.emit()
            elif distance_from_pass < great_press_threshold:
                Signals.IncrementScore.emit(great_press_score)
                press_score_text = "GREAT"
                Signals.IncrementCombo.emit()
            elif distance_from_pass < good_press_threshold:
                Signals.IncrementScore.emit(good_press_score)
                press_score_text = "GOOD"
                Signals.IncrementCombo.emit()
            elif distance_from_pass < ok_press_threshold:
                Signals.IncrementScore.emit(ok_press_score)
                press_score_text = "OK"
                Signals.IncrementCombo.emit()
            else:
                press_score_text = "MISS"
                Signals.ResetCombo.emit()

            key_to_pop.queue_free()
            spawn_score_text(press_score_text)

func CreateFallingKey(button_name: String):
    if not falling_key_container or not score_text_container:
        printerr("CRITICAL ERROR on \'", name, "\': One or both container nodes are not assigned in the Inspector! Notes cannot be spawned.")
        return

    if button_name == key_name:
        var fk_inst = falling_key.instantiate()

        falling_key_container.call_deferred("add_child", fk_inst)

        fk_inst.Setup(position.x, frame + 4)

        falling_key_queue.push_back(fk_inst)

func spawn_score_text(text_to_show: String):
    var st_inst = score_text.instantiate()
    score_text_container.call_deferred("add_child", st_inst)
    st_inst.SetTextInfo(text_to_show)
    st_inst.global_position = global_position + Vector2(0, -20)

func _on_random_spawn_timer_timeout():
    $RandomSpawnTimer.wait_time = randf_range(0.4, 3)
    $RandomSpawnTimer.start()
