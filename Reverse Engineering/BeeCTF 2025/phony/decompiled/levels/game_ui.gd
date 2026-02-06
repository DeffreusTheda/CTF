extends Control

var score: int = 0
var combo_count: int = 0

func _ready():

    Signals.IncrementScore.connect(IncrementScore)
    Signals.IncrementCombo.connect(IncrementCombo)
    Signals.ResetCombo.connect(ResetCombo)

    ResetCombo()

func IncrementScore(incr: int):
    score += incr
    %ScoreLabel.text = " " + str(score) + " pts"

func IncrementCombo():
    combo_count += 1
    %ComboLabel.text = " " + str(combo_count) + "x combo"

func ResetCombo():
    combo_count = 0
    %ComboLabel.text = ""
