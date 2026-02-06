extends Control








func SetTextInfo(text: String):
    $ScoreLevelText.text = "[center]" + text

    match text:
        "PERFECT":
            $ScoreLevelText.set("theme_override_colors/default_color", Color("ffbe00"))
        "GREAT":
            $ScoreLevelText.set("theme_override_colors/default_color", Color("e2dd25"))
        "GOOD":
            $ScoreLevelText.set("theme_override_colors/default_color", Color("e2dd25"))
        "OK":
            $ScoreLevelText.set("theme_override_colors/default_color", Color("8dbfc7"))
        _:
            $ScoreLevelText.set("theme_override_colors/default_color", Color("5a5758"))
